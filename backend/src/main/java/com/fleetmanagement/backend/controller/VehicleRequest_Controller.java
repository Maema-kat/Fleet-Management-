package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.VehicleRequest;
import com.fleetmanagement.backend.service.VehicleRequest_Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleRequest_Controller {
    private final VehicleRequest_Service vehicleRequestService;

    public VehicleRequest_Controller(VehicleRequest_Service vehicleRequestService){
        this.vehicleRequestService = vehicleRequestService;
    }

    @PostMapping
    public VehicleRequest createVehicleRequest(@RequestBody VehicleRequest vehicleRequest){
        return vehicleRequestService.createVehicleRequest(vehicleRequest);
    }
    @GetMapping("/{id}")
    public VehicleRequest getVehicleRequestById(@PathVariable Long id ) {
        return vehicleRequestService.getVehicleRequestById(id);
    }
    @GetMapping
    public List<VehicleRequest> getAllVehicleRequests() {
        return vehicleRequestService.getAllVehicleRequests();
    }
    @PostMapping("/{id}")
    public VehicleRequest updateVehicleRequest(@PathVariable Long id ,@RequestBody VehicleRequest vehicleRequest)
    {
        return vehicleRequestService.updateVehicleRequest(id,vehicleRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteVehicleRequest(@PathVariable Long id ) {
        vehicleRequestService.deleteVehicleRequest(id);
    }
}
