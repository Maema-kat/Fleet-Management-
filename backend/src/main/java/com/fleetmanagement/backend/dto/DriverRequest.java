package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.User;

import java.util.Date;

public class DriverRequest {
    private Long licenseNumber;
    private Date expiryDate;
    private Long userId;

    public Long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber (Long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Long getUserId() {
        return userId;

    }

    public void setUser(Long userId) {
        this.userId = userId;
    }



}
