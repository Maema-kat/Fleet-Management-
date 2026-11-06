package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.AssignmentRequest;
import com.fleetmanagement.backend.entity.*;
import com.fleetmanagement.backend.enums.*;
import com.fleetmanagement.backend.exceptions.BusinessRuleException;
import com.fleetmanagement.backend.exceptions.ResourceNotFoundException;
import com.fleetmanagement.backend.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;

    public AssignmentService(AssignmentRepository assignmentRepository,
                             DriverRepository driverRepository,
                             VehicleRepository vehicleRepository) {
        this.assignmentRepository = assignmentRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public AssignmentEntity createAssignment(AssignmentRequest request) {

        DriverEntity driver = driverRepository.findById(request.getDriverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));
        VehicleEntity vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (!request.getStartDate().isBefore(request.getEndDate()))
            throw new BusinessRuleException("Start date must be before end date");

        // ... keep all the driver and vehicle rule checks exactly as before ...

        AssignmentEntity assignment = new AssignmentEntity();
        assignment.setDriver(driver);
        assignment.setVehicle(vehicle);
        assignment.setStartDate(request.getStartDate());
        assignment.setEndDate(request.getEndDate());
        assignment.setStatus(AssignmentStatus.ACTIVE);

        vehicle.setStatus(VehicleStatus.ASSIGNED);
        vehicleRepository.save(vehicle);

        return assignmentRepository.save(assignment);
    }
    public List<AssignmentEntity> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public AssignmentEntity getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment not found"));
    }

    @Transactional
    public AssignmentEntity endAssignment(Long id) {
        AssignmentEntity assignment = getAssignmentById(id);

        if (assignment.getStatus() != AssignmentStatus.ACTIVE)
            throw new BusinessRuleException("Only active assignments can be ended");

        assignment.setStatus(AssignmentStatus.ENDED);

        VehicleEntity vehicle = assignment.getVehicle();
        if (vehicle.getStatus() == VehicleStatus.ASSIGNED) {   // never override MAINTENANCE or RETIRED
            vehicle.setStatus(VehicleStatus.AVAILABLE);
            vehicleRepository.save(vehicle);
        }

        return assignmentRepository.save(assignment);
    }
}