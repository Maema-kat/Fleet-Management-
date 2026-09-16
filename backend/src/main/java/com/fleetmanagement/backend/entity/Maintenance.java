package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name ="maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @OneToMany
    @JoinColumn(name ="vehicle_id")
    private Vehicle vehicle ;
    private Date maintenanceDate ;
    private String description ;
    private int cost;
    private double odometer ;
    private String status ;
    private Mechanic mechanic;

    public Maintenance () {}
    public Maintenance(Long id , Vehicle vehicle ,Date maintenanceDate,String description,int cost ,double odometer,String status ,Mechanic mechanic) {
        this.id = id ;
        this.vehicle =vehicle ;
        this.maintenanceDate = maintenanceDate;
        this.description =description;
        this.cost =cost;
        this.odometer =odometer;
        this.status = status;
        this.mechanic =mechanic;

    }
    public Long getId() {return id ;}
    public Vehicle getVehicle() {return vehicle;}
    public Date getMaintenanceDate() {return maintenanceDate;}
    public String getDescription() {return description;}
    public int getCost() {return  cost ;}
    public String getStatus() {return status;}
    public Mechanic getMechanic() {return mechanic;}
    public double getOdometer() {return  odometer;}

    public void setVehicle(Vehicle vehicle) {this.vehicle = vehicle;}
    public void setMaintenanceDate(Date maintenanceDate ) {this.maintenanceDate = maintenanceDate;}
    public void setDescription(String description) {this.description = description;}
    public void setCost(int cost) {this.cost =cost ;}
    public void setOdometer(double odometer) {this.odometer = odometer;}
    public void setStatus (String status) {this.status = status;}
    public void setMechanic(Mechanic mechanic) {this.mechanic = mechanic;}
}
