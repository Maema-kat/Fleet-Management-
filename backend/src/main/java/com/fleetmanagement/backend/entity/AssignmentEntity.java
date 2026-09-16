package com.fleetmanagement.backend.entity;
import com.fleetmanagement.backend.entity.Vehicle;
import com.fleetmanagement.backend.entity.Driver;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="assignments")
public class AssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignmentId;
    private Vehicle vehicle;
    private Driver driver;
    private String status ;
    private Date startDate;
    private Date endDate;

public AssignmentEntity() {}

    public Long getAssignmentId() {return  assignmentId;}
    public Vehicle getVehicle() {return vehicle;}
    public Driver getDriver() {return driver;}
    public String getStatus() {return status ;}
    public Date getStartDate() {return startDate;}
    public Date getEndDate() {return endDate;}


    public void setVehicle(Vehicle vehicle){this.vehicle =vehicle;}
    public void setDriver(Driver driver){this.driver = driver;}
    public void setStatus (String status){this.status = status ;}
    public void setStartDate (Date startDate){this.startDate= startDate;}
    public void setEndDate (Date endDate){this.endDate =endDate;}


}
