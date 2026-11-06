package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.CreateVehicleRequestDto;
import com.fleetmanagement.backend.dto.VehicleRequestResponse;
import com.fleetmanagement.backend.service.VehicleRequestService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-requests")
public class VehicleRequestController {

    private final VehicleRequestService service;

    public VehicleRequestController(VehicleRequestService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehicleRequestResponse create(@Valid @RequestBody CreateVehicleRequestDto dto) {
        return VehicleRequestResponse.from(service.createVehicleRequest(dto));
    }

    @GetMapping
    public List<VehicleRequestResponse> getAll() {
        return service.getAllVehicleRequests().stream().map(VehicleRequestResponse::from).toList();
    }

    @GetMapping("/{id}")
    public VehicleRequestResponse getById(@PathVariable Long id) {
        return VehicleRequestResponse.from(service.getVehicleRequestById(id));
    }

    @PutMapping("/{id}/approve")
    public VehicleRequestResponse approve(@PathVariable Long id) {
        return VehicleRequestResponse.from(service.approve(id));
    }

    @PutMapping("/{id}/reject")
    public VehicleRequestResponse reject(@PathVariable Long id) {
        return VehicleRequestResponse.from(service.reject(id));
    }

    @PutMapping("/{id}/cancel")
    public VehicleRequestResponse cancel(@PathVariable Long id) {
        return VehicleRequestResponse.from(service.cancel(id));
    }
}