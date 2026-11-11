package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.enums.TripStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

 public class TripRequest {
  private Long assignmentId;
  private Long startOdometer;
  private Long endOdometer;
  private Double startFuelLevel;
  private Double endFuelLevel;
  private String destination;
  private String purpose;

  public Long getAssignmentId() {return assignmentId;}
  public Long getStartOdometer() {return startOdometer;}
  public Long getEndOdometer () {return endOdometer;}
  public Double getStartFuelLevel() {return startFuelLevel;}
  public Double getEndFuelLevel() {return endFuelLevel;}
  public String getDestination () {return  destination;}
  public String getPurpose () {return  purpose;}

  public void setAssignmentId(Long assignmentId) {this.assignmentId = assignmentId;}
  public void setStartOdometer(Long startOdometer) {this.startOdometer = startOdometer;}
  public void setEndOdometer(Long endOdometer) {this.endOdometer = endOdometer;}
  public void setStartFuelLevel(Double startFuelLevel) {this.startFuelLevel =startFuelLevel;}
  public void setEndFuelLevel (Double endFuelLevel) {this.endFuelLevel = endFuelLevel;}
  public void setDestination (String destination) {this.destination = destination;}
  public void setPurpose (String purpose ){this.purpose = purpose;}




 }



