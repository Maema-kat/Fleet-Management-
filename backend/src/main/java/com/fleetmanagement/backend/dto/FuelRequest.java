package com.fleetmanagement.backend.dto;

import java.util.Date;

public class FuelRequest {

    private long vehicleId;
    private double liters;
    private int cost ;
    private double odometer ;
    private Date date;

    public FuelRequest() {}

    public Long getVehicleId() {return vehicleId;}
    public double getLiters() {return  liters;}
    public int getCost() {return  cost;}
    public double getOdometer() {return odometer;}
    public Date getDate() {return date;}


    public void setLiters(Double liters){this.liters = liters;}
    public void setCost(int cost){this.cost =cost ;}
    public void setOdometer(double odometer) {this.odometer =odometer;}
    public void setDate(Date date){this.date = date ;}

}
