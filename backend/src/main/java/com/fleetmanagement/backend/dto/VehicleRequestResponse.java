package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.VehicleRequestEntity;
import com.fleetmanagement.backend.enums.RequestStatus;

import java.time.LocalDate;

public record VehicleRequestResponse(
        Long id, Long driverId, LocalDate startDate, LocalDate endDate,
        String reason, RequestStatus status
) {
    public static VehicleRequestResponse from(VehicleRequestEntity r) {
        return new VehicleRequestResponse(r.getId(), r.getDriver().getId(),
                r.getStartDate(), r.getEndDate(), r.getReason(), r.getStatus());
    }
}