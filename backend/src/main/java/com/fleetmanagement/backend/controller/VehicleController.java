package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService){this.vehicleService = vehicleService;}

    @PostMapping
    public VehicleEntity createVehicle(@RequestBody VehicleEntity vehicle ) {
        return vehicleService.createVehicle(vehicle);
    }

    @GetMapping("/{id}")
    public VehicleEntity getVehicleById (@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }
    @GetMapping
    public List<VehicleEntity> getAllVehicles (){
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{id}")
    public VehicleEntity updateVehicle(@PathVariable Long id , @RequestBody VehicleEntity vehicle ) {
        return vehicleService.updateVehicle(id,vehicle);
    }
    @DeleteMapping("/{id}")
    public void deleteVehicle (@PathVariable Long id) {vehicleService.deleteVehicle(id);}

}
