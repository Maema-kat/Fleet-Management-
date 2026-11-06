package com.fleetmanagement.backend.dto;

import java.util.Date;

public class MaintenanceRequest {
    private Long vehicleId;
    private Long mechanicId;
    private Date maintenanceDate;
    private String description;
    private int cost;
    private Double odometer;

    public MaintenanceRequest() {
    }

    public Long getVehicleId() {return vehicleId;}
    public Date getMaintenanceDate() {return maintenanceDate;}
    public String getDescription() {return description;}
    public int getCost() {return  cost ;}
    public Long getMechanicId() {return mechanicId;}
    public double getOdometer() {return  odometer;}

    public void setVehicleId(Long vehicleId) {this.vehicleId = vehicleId;}
    public void setMaintenanceDate(Date maintenanceDate ) {this.maintenanceDate = maintenanceDate;}
    public void setDescription(String description) {this.description = description;}
    public void setCost(int cost) {this.cost =cost ;}
    public void setOdometer(double odometer) {this.odometer = odometer;}
    public void setMechanicId(Long mechanicId) {this.mechanicId = mechanicId;}
}
