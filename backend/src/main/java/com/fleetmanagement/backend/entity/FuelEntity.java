package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="fuels")
public class FuelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  fuelId ;

    @OneToMany
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle ;
    private double liters;
    private int cost ;
    private double odometer ;
    private Date date;


    public FuelEntity() {}
    public FuelEntity(Long fuelId,Vehicle vehicle,double liters ,int cost ,double odometer,Date date){
        this.fuelId =fuelId;
        this.cost =cost ;
        this.vehicle = vehicle;
        this. liters = liters;
        this.odometer =odometer;
        this.date = date;

    }

    public long getFuelId() {
        return fuelId;
    }
    public Vehicle getVehicle() {return vehicle;}
    public double getLiters() {return  liters;}
    public int getCost() {return  cost;}
    public double getOdometer() {return odometer;}
    public Date getDate() {return date;}

    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}
    public void setLiters(Double liters){this.liters = liters;}
    public void setCost(int cost){this.cost =cost ;}
    public void setOdometer(double odometer) {this.odometer =odometer;}
    public void setDate(Date date){this.date = date ;}


}
