package com.fleetmanagement.backend.entity;


import com.fleetmanagement.backend.enums.VehicleStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String registrationNumber;

    private String make;
    private String model;
    private Integer year;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleStatus status = VehicleStatus.AVAILABLE;

    @Column(nullable = false)
    private Long mileage = 0L;

    public VehicleEntity() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public VehicleStatus getStatus() { return status; }
    public void setStatus(VehicleStatus status) { this.status = status; }

    public Long getMileage() { return mileage; }
    public void setMileage(Long mileage) { this.mileage = mileage; }
}
