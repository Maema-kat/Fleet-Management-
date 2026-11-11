package com.fleetmanagement.backend.dto;

import java.time.LocalDate;
import java.util.Date;

public record FuelResponse(
        Long id,
        Long vehicleId,
        Double liters,
        Double cost,
        Long odometer,
        LocalDate date) {}