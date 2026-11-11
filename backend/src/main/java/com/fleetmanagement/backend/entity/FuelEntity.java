package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="fuels")
public class FuelEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fuelId ;

    @OneToMany
    @JoinColumn(name="vehicle_id")
    private VehicleEntity vehicle ;
    private Double liters;
    private Double  cost ;
    private Long odometer ;
    private Date date;


    public FuelEntity() {}


    public Long getFuelId() {
        return fuelId;
    }
    public VehicleEntity getVehicle() {return vehicle;}
    public Double getLiters() {return  liters;}
    public Double getCost() {return  cost;}
    public Long getOdometer() {return odometer;}
    public Date getDate() {return date;}

    public void setVehicle(VehicleEntity vehicle) {this.vehicle = vehicle;}
    public void setLiters(Double liters){this.liters = liters;}
    public void setCost(Double cost){this.cost =cost ;}
    public void setOdometer(Long odometer) {this.odometer =odometer;}
    public void setDate(Date date){this.date = date ;}


}
