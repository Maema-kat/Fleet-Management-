package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.MaintenanceRequest;
import com.fleetmanagement.backend.dto.MaintenanceResponse;
import com.fleetmanagement.backend.entity.Maintenance;
import com.fleetmanagement.backend.entity.Mechanic;
import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.enums.AssignmentStatus;
import com.fleetmanagement.backend.enums.MaintenanceStatus;
import com.fleetmanagement.backend.enums.VehicleStatus;
import com.fleetmanagement.backend.exceptions.BusinessRuleException;
import com.fleetmanagement.backend.exceptions.ResourceNotFoundException;
import com.fleetmanagement.backend.repository.MaintenanceRepository;
import com.fleetmanagement.backend.repository.MechanicRepository;
import com.fleetmanagement.backend.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final VehicleRepository vehicleRepository;
    private final MechanicRepository mechanicRepository;

        public MaintenanceService(
                MaintenanceRepository maintenanceRepository,
                VehicleRepository vehicleRepository,
                MechanicRepository mechanicRepository) {

            this.maintenanceRepository = maintenanceRepository;
            this.vehicleRepository = vehicleRepository;
            this.mechanicRepository = mechanicRepository;
        }

    @Transactional
    public MaintenanceResponse createMaintenance(MaintenanceRequest request) {

        VehicleEntity vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
        Mechanic mechanic = mechanicRepository.findById(request.getMechanicId())
                .orElseThrow(() -> new ResourceNotFoundException("Mechanic not found"));

        if (request.getMaintenanceDate() == null || request.getDescription() == null
                || request.getDescription().isBlank())
            throw new BusinessRuleException("Maintenance date and description are required");
        if (request.getCost() != null && request.getCost() < 0)
            throw new BusinessRuleException("Maintenance cost cannot be negative");

        Maintenance maintenance = new Maintenance();
        maintenance.setVehicle(vehicle);
        maintenance.setMechanic(mechanic);
        maintenance.setMaintenanceDate(request.getMaintenanceDate());
        maintenance.setDescription(request.getDescription());
        maintenance.setCost(request.getCost());
        maintenance.setOdometer(request.getOdometer());
        maintenance.setStatus(MaintenanceStatus.SCHEDULED);

        return toResponse(maintenanceRepository.save(maintenance));
    }

    @Transactional
    public MaintenanceResponse startMaintenance(Long id) {
        Maintenance maintenance = findOrThrow(id);

        if (maintenance.getStatus() != MaintenanceStatus.SCHEDULED)
            throw new BusinessRuleException("Only scheduled maintenance can be started");

        VehicleEntity vehicle = maintenance.getVehicle();
        if (assignmentRepository.existsByVehicleIdAndStatus(vehicle.getId(), AssignmentStatus.ACTIVE))
            throw new BusinessRuleException("End the vehicle's active assignment before starting maintenance");

        maintenance.setStatus(MaintenanceStatus.IN_PROGRESS);
        vehicle.setStatus(VehicleStatus.MAINTENANCE);
        vehicleRepository.save(vehicle);

        return toResponse(maintenanceRepository.save(maintenance));
    }

    @Transactional
    public MaintenanceResponse completeMaintenance(Long id) {
        Maintenance maintenance = findOrThrow(id);

        if (maintenance.getStatus() != MaintenanceStatus.IN_PROGRESS)
            throw new BusinessRuleException("Only maintenance in progress can be completed");

        maintenance.setStatus(MaintenanceStatus.COMPLETED);

        VehicleEntity vehicle = maintenance.getVehicle();
        if (vehicle.getStatus() == VehicleStatus.MAINTENANCE) {   // never touch a RETIRED vehicle
            vehicle.setStatus(VehicleStatus.AVAILABLE);
            vehicleRepository.save(vehicle);
        }

        return toResponse(maintenanceRepository.save(maintenance));
    }

    public MaintenanceResponse getMaintenanceById(Long id) {
        return toResponse(findOrThrow(id));
    }

    private Maintenance findOrThrow(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Maintenance not found"));
    }

    private MaintenanceResponse toResponse(Maintenance m) {
        return new MaintenanceResponse(
                m.getId(),
                m.getVehicle().getId(),          // was getVehicleId()
                m.getMechanic().getId(),
                m.getMaintenanceDate(),
                m.getDescription(),
                m.getCost(),
                m.getOdometer(),
                m.getStatus().name());           // remove .name() if the response field is the enum
    }

        public MaintenanceResponse getMaintenanceById(Long id) {

            Maintenance maintenance =
                    maintenanceRepository.findById(id)
                            .orElseThrow(() ->
                                    new RuntimeException(
                                            "Maintenance not found"));

            return new MaintenanceResponse(
                    maintenance.getId(),
                    maintenance.getVehicle().getVehicleId(),
                    maintenance.getMechanic().getId(),
                    maintenance.getMaintenanceDate(),
                    maintenance.getDescription(),
                    maintenance.getCost(),
                    maintenance.getOdometer(),
                    maintenance.getStatus()
            );
        }
    }

