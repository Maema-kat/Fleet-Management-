package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.Vehicle;

import java.util.Date;

public class FuelResponse {
    private Long fuelId;
    private long vehicleId;
    private double liters;
    private int cost ;
    private double odometer ;
    private Date date;

    public FuelResponse() {}
    public FuelResponse(Long fuelId, Long vehicleId, double liters , int cost , double odometer, Date date){
        this.fuelId =fuelId;
        this.cost =cost ;
        this.vehicleId = vehicleId;
        this. liters = liters;
        this.odometer =odometer;
        this.date = date;

    }

    public long getFuelId() {
        return fuelId;
    }
    public Long getVehicleId() {return vehicleId;}
    public double getLiters() {return  liters;}
    public int getCost() {return  cost;}
    public double getOdometer() {return odometer;}
    public Date getDate() {return date;}

}
