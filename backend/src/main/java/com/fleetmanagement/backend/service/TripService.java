package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.TripRequest;
import com.fleetmanagement.backend.dto.TripResponse;
import com.fleetmanagement.backend.entity.*;
import com.fleetmanagement.backend.enums.*;
import com.fleetmanagement.backend.exceptions.BusinessRuleException;
import com.fleetmanagement.backend.exceptions.ResourceNotFoundException;
import com.fleetmanagement.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final AssignmentRepository assignmentRepository;
    private final VehicleRepository vehicleRepository;

    public TripService(TripRepository tripRepository,
                       AssignmentRepository assignmentRepository,
                       VehicleRepository vehicleRepository) {
        this.tripRepository = tripRepository;
        this.assignmentRepository = assignmentRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public TripResponse startTrip(TripRequest request) {

        AssignmentEntity assignment = assignmentRepository.findById(request.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));

        if (assignment.getStatus() != AssignmentStatus.ACTIVE)
            throw new BusinessRuleException("A trip can only start under an active assignment");

        VehicleEntity vehicle = assignment.getVehicle();
        if (vehicle.getStatus() == VehicleStatus.MAINTENANCE || vehicle.getStatus() == VehicleStatus.RETIRED)
            throw new BusinessRuleException("Vehicle is not operational");

        if (tripRepository.existsByAssignmentVehicleIdAndStatus(vehicle.getId(), TripStatus.IN_PROGRESS))
            throw new BusinessRuleException("This vehicle already has a trip in progress");

        if (request.getStartOdometer() == null)
            throw new BusinessRuleException("Starting odometer is required");
        if (request.getStartOdometer() < vehicle.getMileage())
            throw new BusinessRuleException("Starting odometer cannot be lower than the vehicle's current mileage");

        if (request.getStartFuelLevel() == null || request.getStartFuelLevel() < 0)
            throw new BusinessRuleException("A valid, non-negative starting fuel level is required");

        TripEntity trip = new TripEntity();
        trip.setAssignment(assignment);
        trip.setStartDateTime(LocalDateTime.now());
        trip.setStartOdometer(request.getStartOdometer());
        trip.setStartFuelLevel(request.getStartFuelLevel());
        trip.setDestination(request.getDestination());
        trip.setPurpose(request.getPurpose());
        trip.setStatus(TripStatus.IN_PROGRESS);

        return mapToResponse(tripRepository.save(trip));
    }

    @Transactional
    public TripResponse endTrip(Long tripId, TripRequest request) {

        TripEntity trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found"));

        if (trip.getStatus() != TripStatus.IN_PROGRESS)
            throw new BusinessRuleException("Only a trip in progress can be completed");

        if (request.getEndOdometer() == null)
            throw new BusinessRuleException("Ending odometer is required");
        if (request.getEndFuelLevel() == null)
            throw new BusinessRuleException("Ending fuel level is required");
        if (request.getEndOdometer() < trip.getStartOdometer())
            throw new BusinessRuleException("Ending odometer cannot be less than starting odometer");
        if (request.getEndFuelLevel() < 0)
            throw new BusinessRuleException("Ending fuel level cannot be negative");

        trip.setEndOdometer(request.getEndOdometer());
        trip.setEndFuelLevel(request.getEndFuelLevel());
        trip.setEndDateTime(LocalDateTime.now());
        trip.setStatus(TripStatus.COMPLETED);

        // Completing a trip updates the vehicle's mileage
        VehicleEntity vehicle = trip.getAssignment().getVehicle();
        vehicle.setMileage(request.getEndOdometer());
        vehicleRepository.save(vehicle);

        return mapToResponse(tripRepository.save(trip));
    }

    private TripResponse mapToResponse(TripEntity trip) {
        TripResponse response = new TripResponse();

        response.setId(trip.getId());
        if (trip.getAssignment() != null)
            response.setAssignmentId(trip.getAssignment().getId());

        response.setStartDateTime(trip.getStartDateTime());
        response.setEndDateTime(trip.getEndDateTime());
        response.setStartOdometer(trip.getStartOdometer());
        response.setEndOdometer(trip.getEndOdometer());
        response.setStartFuelLevel(trip.getStartFuelLevel());
        response.setEndFuelLevel(trip.getEndFuelLevel());
        response.setDestination(trip.getDestination());
        response.setPurpose(trip.getPurpose());
        response.setStatus(trip.getStatus().name());   // remove .name() if TripResponse.status is TripStatus

        return response;
    }
}