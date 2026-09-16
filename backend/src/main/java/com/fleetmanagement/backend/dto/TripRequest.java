package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.AssignmentEntity;

import java.time.LocalDateTime;

public class TripRequest {
    private Long assignmentId ;
    private AssignmentEntity assignment;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private Double startOdometer;
    private Double endOdometer;

    private Double startFuelLevel;
    private Double endFuelLevel;

    private String destination;
    private String purpose;

    private String status;

    public TripRequest() {
    }


    public Long getAssignmentId() {return assignmentId;}
    public AssignmentEntity getAssignment() {return assignment;}
    public LocalDateTime getStartDateTime () {return startDateTime;}
    public LocalDateTime getEndDateTime () {return endDateTime;}
    public Double getStartOdometer() {return startOdometer;}
    public Double getEndOdometer() {return endOdometer;}
    public Double getStartFuelLevel() {return startFuelLevel;}
    public Double getEndFuelLevel() {return endFuelLevel;}
    public String getDestination() {return destination;}
    public String getPurpose() {return purpose;}
    public String getStatus() {return status;}

    public void setAssignment (AssignmentEntity assignment) {this.assignment = assignment;}
    public void setStartDateTime(LocalDateTime startDateTime){this.startDateTime = startDateTime;}
    public void setEndDateTime (LocalDateTime endDateTime) {this.endDateTime = endDateTime;}
    public void setStartOdometer(Double startOdometer){this.startOdometer = startOdometer;}
    public void setEndOdometer (Double endOdometer) {this.startOdometer =endOdometer;}
    public void setStartFuelLevel (Double startFuelLevel) {this.startFuelLevel = startFuelLevel;}
    public void setStatus (String status){this.status =status ;}
    public void setEndFuelLevel(Double endFuelLevel){this.endFuelLevel = endFuelLevel;}
    public void setDestination(String destination){this.destination=destination;}
    public void setPurpose(String purpose ) {this.purpose =purpose;}


}


