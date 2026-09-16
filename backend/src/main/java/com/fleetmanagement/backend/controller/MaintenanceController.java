package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.MaintenanceRequest;
import com.fleetmanagement.backend.dto.MaintenanceResponse;
import com.fleetmanagement.backend.service.MaintenanceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(
            MaintenanceService maintenanceService) {

        this.maintenanceService = maintenanceService;
    }

    @PostMapping
    public MaintenanceResponse createMaintenance(
            @RequestBody MaintenanceRequest request) {

        return maintenanceService.createMaintenance(request);
    }

    @GetMapping("/{id}")
    public MaintenanceResponse getMaintenanceById(
            @PathVariable Long id) {

        return maintenanceService.getMaintenanceById(id);
    }
}
