package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.enums.AssignmentStatus;
import java.time.LocalDate;

public record AssignmentResponse(
        Long id,
        Long driverId,
        Long vehicleId,
        String vehicleRegistration,
        LocalDate startDate,
        LocalDate endDate,
        AssignmentStatus status
) {
    public static AssignmentResponse from(AssignmentEntity a) {
        return new AssignmentResponse(
                a.getId(),
                a.getDriver().getId(),
                a.getVehicle().getId(),
                a.getVehicle().getRegistrationNumber(),
                a.getStartDate(),
                a.getEndDate(),
                a.getStatus()
        );
    }
}