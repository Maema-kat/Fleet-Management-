package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.CreateVehicleRequestDto;
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
public class VehicleRequestService {

    private final VehicleRequestRepository requestRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final AssignmentRepository assignmentRepository;

    public VehicleRequestService(VehicleRequestRepository requestRepository,
                                 DriverRepository driverRepository,
                                 VehicleRepository vehicleRepository,
                                 AssignmentRepository assignmentRepository) {
        this.requestRepository = requestRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Transactional
    public VehicleRequestEntity createVehicleRequest(CreateVehicleRequestDto dto) {

        DriverEntity driver = driverRepository.findById(dto.driverId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found"));

        if (driver.getStatus() == DriverStatus.SUSPENDED)
            throw new BusinessRuleException("Suspended driver cannot request a vehicle");

        if (assignmentRepository.existsByDriverIdAndStatus(driver.getId(), AssignmentStatus.ACTIVE))
            throw new BusinessRuleException("Driver already has an active assignment");

        if (!dto.startDate().isBefore(dto.endDate()))
            throw new BusinessRuleException("Start date must be before end date");

        // Proposed policy: at least one day's notice (change to suit your organisation)
        if (!dto.startDate().isAfter(LocalDate.now()))
            throw new BusinessRuleException("Requests need at least 24 hours' notice");

        VehicleRequestEntity request = new VehicleRequestEntity();
        request.setDriver(driver);
        request.setStartDate(dto.startDate());
        request.setEndDate(dto.endDate());
        request.setReason(dto.reason());
        request.setStatus(RequestStatus.PENDING);

        return requestRepository.save(request);
    }

    public List<VehicleRequestEntity> getAllVehicleRequests() {
        return requestRepository.findAll();
    }

    public VehicleRequestEntity getVehicleRequestById(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle request not found"));
    }

    @Transactional
    public VehicleRequestEntity approve(Long id) {
        VehicleRequestEntity request = getVehicleRequestById(id);

        if (request.getStatus() != RequestStatus.PENDING)
            throw new BusinessRuleException("Only pending requests can be approved");

        if (!vehicleRepository.existsByStatus(VehicleStatus.AVAILABLE))
            throw new BusinessRuleException("No available vehicle to approve this request");

        request.setStatus(RequestStatus.APPROVED);
        return requestRepository.save(request);
    }

    @Transactional
    public VehicleRequestEntity reject(Long id) {
        VehicleRequestEntity request = getVehicleRequestById(id);

        if (request.getStatus() != RequestStatus.PENDING)
            throw new BusinessRuleException("Only pending requests can be rejected");

        request.setStatus(RequestStatus.REJECTED);
        return requestRepository.save(request);
    }

    @Transactional
    public VehicleRequestEntity cancel(Long id) {
        VehicleRequestEntity request = getVehicleRequestById(id);

        if (request.getStatus() != RequestStatus.PENDING && request.getStatus() != RequestStatus.APPROVED)
            throw new BusinessRuleException("Only pending or approved requests can be cancelled");

        request.setStatus(RequestStatus.CANCELLED);
        return requestRepository.save(request);
    }
}




