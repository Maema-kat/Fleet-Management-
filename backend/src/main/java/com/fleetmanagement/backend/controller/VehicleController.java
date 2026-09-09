package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.Vehicle;
import com.fleetmanagement.backend.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){this.vehicleService = vehicleService;}

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle ) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById (@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }
    @GetMapping
    public List<Vehicle> getAllVehicles (){
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id ,@RequestBody Vehicle vehicle ) {
        return vehicleService.updateVehicle(id,vehicle);
    }
    @DeleteMapping("/{id}")
    public void deleteVehicle (@PathVariable Long id) {vehicleService.deleteVehicle(id);}

}
