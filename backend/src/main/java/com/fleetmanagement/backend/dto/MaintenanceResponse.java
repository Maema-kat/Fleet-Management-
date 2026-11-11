package com.fleetmanagement.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public record MaintenanceResponse(
        Long id,
        Long vehicleId,
        Long mechanicId,
        LocalDate maintenanceDate,
        String description,
        Double cost,
        Long odometer,
        String status) {}