package com.fleetmanagement.backend.dto;

public class MechanicResponse {
    private Long employeeNumber;
    private String name ;
    private Long userId;

    public MechanicResponse() {}

    public MechanicResponse (Long employeeNumber,String name ,Long userId) {
        this.employeeNumber = employeeNumber;
        this.name =name ;
        this.userId= userId;
    }
    public Long getEmployeeNumber(){return employeeNumber;}
    public String getName () {return name ;}
    public Long getUserId() {return userId;}
}

