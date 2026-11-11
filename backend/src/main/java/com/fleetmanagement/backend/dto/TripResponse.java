package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.TripEntity;
import com.fleetmanagement.backend.enums.TripStatus;

import java.time.LocalDateTime;

public record TripResponse(
        Long id,
        Long assignmentId,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        Long startOdometer,
        Long endOdometer,
        Double startFuelLevel,
        Double endFuelLevel,
        Long distanceTravelled,
        Double fuelLevelUsed,
        String destination,
        String purpose,
        TripStatus status
) {
    public static TripResponse from(TripEntity tr) {

        Long distance = (tr.getEndOdometer() != null)
                ? tr.getEndOdometer() - tr.getStartOdometer()
                : null;

        Double fuelUsed = (tr.getEndFuelLevel() != null)
                ? tr.getStartFuelLevel() - tr.getEndFuelLevel()
                : null;

        return new TripResponse(
                tr.getId(),
                tr.getAssignment().getId(),
                tr.getStartDateTime(),
                tr.getEndDateTime(),
                tr.getStartOdometer(),
                tr.getEndOdometer(),
                tr.getStartFuelLevel(),
                tr.getEndFuelLevel(),
                distance,
                fuelUsed,
                tr.getDestination(),
                tr.getPurpose(),
                tr.getStatus()
        );
    }
}