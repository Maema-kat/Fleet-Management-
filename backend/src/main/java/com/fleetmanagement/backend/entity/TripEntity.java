package com.fleetmanagement.backend.entity;

import com.fleetmanagement.backend.enums.MaintenanceStatus;
import com.fleetmanagement.backend.enums.TripStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="trips")
public class TripEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "assignment_id")
        private AssignmentEntity assignment;

        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;

     @Column(nullable = false)
    private Long startOdometer;

    private Long endOdometer;


    private Double startFuelLevel;
        private Double endFuelLevel;

        private String destination;
        private String purpose;

        private TripStatus status;

        public TripEntity() {
        }


    public Long getId() {return id;}
    public AssignmentEntity getAssignment() {return assignment;}
    public LocalDateTime getStartDateTime () {return startDateTime;}
    public LocalDateTime getEndDateTime () {return endDateTime;}
    public Long getStartOdometer() { return startOdometer; }
    public Long getEndOdometer() { return endOdometer; }
    public Double getStartFuelLevel() {return startFuelLevel;}
    public Double getEndFuelLevel() {return endFuelLevel;}
    public String getDestination() {return destination;}
    public String getPurpose() {return purpose;}
    public TripStatus getStatus() {return status;}

    public void setAssignment (AssignmentEntity assignment) {this.assignment = assignment;}
    public void setStartDateTime(LocalDateTime startDateTime){this.startDateTime = startDateTime;}
    public void setEndDateTime (LocalDateTime endDateTime) {this.endDateTime = endDateTime;}
    public void setStartOdometer(Long startOdometer) { this.startOdometer = startOdometer; }
    public void setEndOdometer(Long endOdometer) { this.endOdometer = endOdometer; }
    public void setStartFuelLevel (Double startFuelLevel) {this.startFuelLevel = startFuelLevel;}
    public void setStatus (TripStatus status){this.status =status ;}
    public void setEndFuelLevel(Double endFuelLevel){this.endFuelLevel = endFuelLevel;}
    public void setDestination(String destination){this.destination=destination;}
    public void setPurpose(String purpose ) {this.purpose =purpose;}


}
