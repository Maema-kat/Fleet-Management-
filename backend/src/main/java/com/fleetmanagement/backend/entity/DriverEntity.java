package com.fleetmanagement.backend.entity;
import com.fleetmanagement.backend.enums.DriverStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "drivers")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriverStatus status = DriverStatus.ACTIVE;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public DriverEntity() {}

    public Long getId() { return id; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public LocalDate getExpiryDate() { return expiryDate; }
    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    public DriverStatus getStatus() { return status; }
    public void setStatus(DriverStatus status) { this.status = status; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}