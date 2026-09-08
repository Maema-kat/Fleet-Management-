package com.fleetmanagement.backend.dto;


public class VehicleRequest {

    private Long registrationNumber;
    private Long vehicleId;
    private String model;
    private String make;
    private Long year;
    private String status;
    private Long mileage;

    public VehicleRequest() {
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
