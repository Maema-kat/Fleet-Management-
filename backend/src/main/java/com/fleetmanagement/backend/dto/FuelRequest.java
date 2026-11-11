package com.fleetmanagement.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.Date;

public class FuelRequest {
    @NotNull private Long vehicleId;
    @NotNull private LocalDate date;
    @NotNull @Positive private Double liters;
    @NotNull @Positive
    private Double cost;
    @NotNull private Long odometer;

    public Long getVehicleId () {return vehicleId;}
    public LocalDate getDate () {return date;}
    public Double getLiters () {return liters;}
    public Double getCost() {return cost ;}
    public Long getOdometer () {return odometer;}

    public void setVehicleId(Long vehicleId) {this.vehicleId=vehicleId;}
    public void setDate(LocalDate date) {this.date =date ;}
    public void setLiters (Double liters){this.liters = liters;}
    public void setCost (Double cost){this.cost =cost ;}
    public void setOdometer(Long odometer) {this.odometer = odometer;}
}
