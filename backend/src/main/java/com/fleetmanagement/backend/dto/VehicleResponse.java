package com.fleetmanagement.backend.dto;

public class VehicleResponse {
    private Long registrationNumber;
    private Long vehicleId;
    private String model;
    private String make;
    private Long year;
    private String status;
    private Long mileage;

    public VehicleResponse() {
    }
    public VehicleResponse(Long vehicleId,String model ,Long registrationNumber, String make, Long year, String status, Long mileage) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.year = year;
        this.status = status;
        this.mileage = mileage;
        this.model =model ;
    }

    public Long getRegistrationNumber() {
        return registrationNumber;
    }
    public String getMake() {
        return make;
    }
    public Long getYear() {
        return year;
    }
    public Long getMileage() {
        return mileage;
    }
    public String getStatus() {
        return status;
    }
    public String getModel() {
        return model;
    }
    public Long getVehicleId() {
        return vehicleId;
    }

}
