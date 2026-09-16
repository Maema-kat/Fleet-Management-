package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.Driver;
import com.fleetmanagement.backend.entity.Vehicle;

import java.util.Date;

public class AssignmentResponse {
    private Long assignmentId;
    private Vehicle vehicle;
    private Driver driver;
    private String status ;
    private Date startDate;
    private Date endDate;


    public AssignmentResponse() {}
    public AssignmentResponse(Long assignmentId,Vehicle vehicle ,Driver driver ,String status,Date startDate,Date endDate) {
        this.assignmentId =assignmentId;
        this.vehicle = vehicle ;
        this.driver= driver;
        this.status =status;
        this.startDate =startDate;
        this.endDate = endDate;
    }


    public Long getAssignmentId() {return  assignmentId;}
    public Vehicle getVehicle() {return vehicle;}
    public Driver getDriver() {return driver;}
    public String getStatus() {return status ;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}



}
