package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.TripRequest;
import com.fleetmanagement.backend.dto.TripResponse;
import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.entity.TripEntity;
import com.fleetmanagement.backend.repository.TripRepository;
import com.fleetmanagement.backend.repository.Assignment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TripService {



        private final TripRepository tripRepository;
        private final Assignment assignmentRepository;

        public TripService(
                TripRepository tripRepository,
                Assignment assignmentRepository) {

            this.tripRepository = tripRepository;
            this.assignmentRepository = assignmentRepository;
        }

        public TripResponse startTrip(TripRequest request) {

            AssignmentEntity assignment =
                    assignmentRepository.findById(request.getAssignmentId())
                            .orElseThrow(() ->
                                    new RuntimeException("Assignment not found"));

            TripEntity trip = new TripEntity();


            trip.setAssignment(assignment);
            trip.setStartDateTime(LocalDateTime.now());
            trip.setStartOdometer(request.getStartOdometer());
            trip.setStartFuelLevel(request.getStartFuelLevel());
            trip.setDestination(request.getDestination());
            trip.setPurpose(request.getPurpose());
            trip.setStatus("IN_PROGRESS");

            TripEntity savedTrip = tripRepository.save(trip);

            return mapToResponse(savedTrip);
        }
    private TripResponse mapToResponse(TripEntity trip) {

        TripResponse response = new TripResponse();

        trip.getId();

        if (trip.getAssignment() != null) {

                    trip.getAssignment().getAssignmentId();
            ;
        }

        response.setStartDateTime(trip.getStartDateTime());
        response.setEndDateTime(trip.getEndDateTime());

        response.setStartOdometer(trip.getStartOdometer());
        response.setEndOdometer(trip.getEndOdometer());

        response.setStartFuelLevel(trip.getStartFuelLevel());
        response.setEndFuelLevel(trip.getEndFuelLevel());

        response.setDestination(trip.getDestination());
        response.setPurpose(trip.getPurpose());

        response.setStatus(trip.getStatus());

        return response;
    }
    public TripResponse endTrip(Long tripId, TripRequest request) {

        TripEntity trip = tripRepository.findById(tripId)
                .orElseThrow(() ->
                        new RuntimeException("Trip not found"));

        if (trip.getStatus().equals("COMPLETED")) {
            throw new RuntimeException("Trip is already completed");
        }

        if (request.getEndOdometer() == null) {
            throw new RuntimeException("Ending odometer is required");
        }

        if (request.getEndFuelLevel() == null) {
            throw new RuntimeException("Ending fuel level is required");
        }

        if (request.getEndOdometer() < trip.getStartOdometer()) {
            throw new RuntimeException(
                    "Ending odometer cannot be less than starting odometer");
        }

        if (request.getEndFuelLevel() < 0) {
            throw new RuntimeException(
                    "Ending fuel level cannot be negative");
        }

        trip.setEndOdometer(request.getEndOdometer());
        trip.setEndFuelLevel(request.getEndFuelLevel());
        trip.setEndDateTime(LocalDateTime.now());
        trip.setStatus("COMPLETED");

        TripEntity savedTrip = tripRepository.save(trip);

        return mapToResponse(savedTrip);
    }
}
