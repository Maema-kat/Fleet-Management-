package com.fleetmanagement.backend.entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false,unique = true)
    private Long licenseNumber ;

    private Long expiryDate ;

  @OneToOne
    @JoinColumn(name="user_id")
    private User user;

  public Long getId() {
      return id;
  }

  public Long getLicenseNumber() {
      return licenseNumber;
  }

  public void setLicenseNumber (Long licenseNumber) {
      this.licenseNumber = licenseNumber;
  }

  public Long getExpiryDate() {
      return expiryDate;
  }

  public void setExpiryDate(Long expiryDate) {
      this.expiryDate = expiryDate;
  }

  public User getUser() {
      return user;

  }

  public void setUser(User user) {
      this.user = user;
  }


}
