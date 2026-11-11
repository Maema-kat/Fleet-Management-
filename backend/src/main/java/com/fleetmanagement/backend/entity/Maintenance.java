package com.fleetmanagement.backend.entity;

import com.fleetmanagement.backend.enums.MaintenanceStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name ="maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private Mechanic mechanic;

    @Column(nullable = false)
    private LocalDate maintenanceDate;

    @Column(nullable = false)
    private String description;

    private Double cost;
    private Long odometer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaintenanceStatus status = MaintenanceStatus.SCHEDULED;


    public Maintenance () {}

    public Long getId() {return id ;}
    public VehicleEntity getVehicle() {return vehicle;}
    public LocalDate getMaintenanceDate() {return maintenanceDate;}
    public String getDescription() {return description;}
    public Double getCost() {return  cost ;}
    public MaintenanceStatus getStatus() {return status;}
    public Mechanic getMechanic() {return mechanic;}
    public double getOdometer() {return  odometer;}

    public void setVehicle(VehicleEntity vehicle) {this.vehicle = vehicle;}
    public void setMaintenanceDate(LocalDate maintenanceDate ) {this.maintenanceDate = maintenanceDate;}
    public void setDescription(String description) {this.description = description;}
    public void setCost(double cost) {this.cost =cost ;}
    public void setOdometer(Long odometer) {this.odometer = odometer;}
    public void setStatus (MaintenanceStatus status) {this.status = status;}
    public void setMechanic(Mechanic mechanic) {this.mechanic = mechanic;}
}
