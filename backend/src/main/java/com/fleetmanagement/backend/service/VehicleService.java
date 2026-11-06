package com.fleetmanagement.backend.service;


import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.repository.VehicleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public VehicleEntity createVehicle (VehicleEntity vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public VehicleEntity getVehicleById (Long id) {
        return vehicleRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehicle with ID NOT FOUND"));
    }
    public List<VehicleEntity> getAllVehicles() {return vehicleRepository.findAll();}

    public VehicleEntity updateVehicle(Long id , VehicleEntity updatedVehicle) {
        VehicleEntity existingVehicle = vehicleRepository.findById(id).orElseThrow(()->new RuntimeException("Vehicle not found"));

        existingVehicle.setMake(updatedVehicle.getMake());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setStatus(updatedVehicle.getStatus());

        return vehicleRepository.save(existingVehicle);
    }
    public void deleteVehicle (Long id ){
        VehicleEntity vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicleRepository.delete(vehicle);
    }

}
