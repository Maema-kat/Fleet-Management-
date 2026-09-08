package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(nullable = false)
    private Long registrationNumber;

    private String model;
    private String make;
    private Long year;
    private String status;
    private Long mileage;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId,Long registrationNumber, String make, Long year, String status, Long mileage) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.year = year;
        this.status = status;
        this.mileage = mileage;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make ) {
        this.make = make;
    }
    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model= model;
    }
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}