package com.fleetmanagement.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;
import java.util.Date;

public class MaintenanceRequest {
    @NotNull
    private Long vehicleId;
    @NotNull
    private Long mechanicId;
    @NotNull
    private LocalDate maintenanceDate;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double cost;
    private Long odometer;

    public Long getVehicleId () {return vehicleId;}
    public Long getMechanicId() {return mechanicId;}
    public LocalDate getMaintenanceDate() {return maintenanceDate;}
    public String getDescription () {return description;}
    public Double getCost () {return cost;}
    public Long getOdometer() {return  odometer;}

    public void setVehicleId (Long vehicleId) {this.vehicleId = vehicleId;}
    public void setMechanicId (Long mechanicId) {this.mechanicId = mechanicId;}
    public void setMaintenanceDate (LocalDate maintenanceDate) {this.maintenanceDate =maintenanceDate;}
    public void setDescription (String description) {this.description = description;}
    public void setCost (Double cost) {this.cost = cost;}
    public void setOdometer (Long odometer) {this.odometer = odometer;}

}
