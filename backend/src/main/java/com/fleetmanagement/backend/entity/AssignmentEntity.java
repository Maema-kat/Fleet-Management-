package com.fleetmanagement.backend.entity;

import com.fleetmanagement.backend.enums.AssignmentStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "assignments")
public class AssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private DriverEntity driver;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssignmentStatus status = AssignmentStatus.ACTIVE;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    public AssignmentEntity() {}

    public Long getId() { return id; }

    public VehicleEntity getVehicle() { return vehicle; }
    public void setVehicle(VehicleEntity vehicle) { this.vehicle = vehicle; }

    public DriverEntity getDriver() { return driver; }
    public void setDriver(DriverEntity driver) { this.driver = driver; }

    public AssignmentStatus getStatus() { return status; }
    public void setStatus(AssignmentStatus status) { this.status = status; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}