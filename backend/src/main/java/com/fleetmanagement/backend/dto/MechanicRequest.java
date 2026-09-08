package com.fleetmanagement.backend.dto;
import com.fleetmanagement.backend.entity.User;

public class MechanicRequest {
    private Long employeeNumber;
    private String name ;
    private Long userId;

    public Long getEmployeeNumber(){return employeeNumber;}
    public void setEmployeeNumber(Long employeeNumber) {this.employeeNumber =employeeNumber;}

    public String getName () {return name ;}
    public void setName(String name) {this.name = name;}

    public Long getUserId() {return userId;}
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
