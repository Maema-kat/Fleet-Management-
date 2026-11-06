package com.fleetmanagement.backend.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateVehicleRequestDto(
        @NotNull Long driverId,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        String reason
) {}