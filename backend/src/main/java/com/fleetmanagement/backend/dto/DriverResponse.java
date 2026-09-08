package com.fleetmanagement.backend.dto;

import java.util.Date;

public class DriverResponse {
    private Long id ;
    private Date expiryDate;
    private Long licenseNumber;
    private String user;

public DriverResponse() {

}
public DriverResponse(Long id ,Date expiryDate,Long licenseNumber,String user) {
    this.expiryDate =expiryDate;
    this.id = id ;
    this.licenseNumber =licenseNumber;
    this.user = user;

}
public Long getId() {
    return id;
}
    public Long getLicenseNumber() {
        return licenseNumber;
    }


    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getUser() {
        return user;

    }

}
