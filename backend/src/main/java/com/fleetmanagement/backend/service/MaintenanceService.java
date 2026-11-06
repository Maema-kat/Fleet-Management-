package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.MaintenanceRequest;
import com.fleetmanagement.backend.dto.MaintenanceResponse;
import com.fleetmanagement.backend.entity.Maintenance;
import com.fleetmanagement.backend.entity.Mechanic;
import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.repository.MaintenanceRepository;
import com.fleetmanagement.backend.repository.MechanicRepository;
import com.fleetmanagement.backend.repository.VehicleRepository;
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

        public MaintenanceResponse createMaintenance(
                MaintenanceRequest request) {

            VehicleEntity vehicle = vehicleRepository.findById(
                    request.getVehicleId()
            ).orElseThrow(() ->
                    new RuntimeException("Vehicle not found"));

            Mechanic mechanic = mechanicRepository.findById(
                    request.getMechanicId()
            ).orElseThrow(() ->
                    new RuntimeException("Mechanic not found"));

            Maintenance maintenance = new Maintenance();

            maintenance.setVehicle(vehicle);
            maintenance.setMechanic(mechanic);
            maintenance.setMaintenanceDate(
                    request.getMaintenanceDate());
            maintenance.setDescription(
                    request.getDescription());
            maintenance.setCost(
                    request.getCost());
            maintenance.setOdometer(
                    request.getOdometer());

            // For now, while we're still using Strings
            maintenance.setStatus("SCHEDULED");

            Maintenance savedMaintenance =
                    maintenanceRepository.save(maintenance);

            return new MaintenanceResponse(
                    savedMaintenance.getId(),
                    savedMaintenance.getVehicle().getVehicleId(),
                    savedMaintenance.getMechanic().getId(),
                    savedMaintenance.getMaintenanceDate(),
                    savedMaintenance.getDescription(),
                    savedMaintenance.getCost(),
                    savedMaintenance.getOdometer(),
                    savedMaintenance.getStatus()
            );
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

