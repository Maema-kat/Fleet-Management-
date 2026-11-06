


package com.fleetmanagement.backend.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AssignmentRequest {

    @NotNull
    private Long driverId;

    @NotNull
    private Long vehicleId;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public AssignmentRequest() {}

    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}