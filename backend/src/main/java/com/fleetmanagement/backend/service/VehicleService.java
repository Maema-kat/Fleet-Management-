package com.fleetmanagement.backend.service;


import com.fleetmanagement.backend.entity.Vehicle;
import com.fleetmanagement.backend.repository.VehicleRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    public Vehicle createVehicle (Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
    public Vehicle getVehicleById (Long id) {
        return vehicleRepository.findById(id).orElseThrow(()-> new RuntimeException("Vehicle with ID NOT FOUND"));
    }
    public List<Vehicle> getAllVehicles() {return vehicleRepository.findAll();}

    public Vehicle updateVehicle(Long id ,Vehicle updatedVehicle) {
        Vehicle existingVehicle = vehicleRepository.findById(id).orElseThrow(()->new RuntimeException("Vehicle not found"));

        existingVehicle.setMake(updatedVehicle.getMake());
        existingVehicle.setModel(updatedVehicle.getModel());
        existingVehicle.setStatus(updatedVehicle.getStatus());

        return vehicleRepository.save(existingVehicle);
    }
    public void deleteVehicle (Long id ){
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicleRepository.delete(vehicle);
    }

}
