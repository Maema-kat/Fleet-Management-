package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;


@Entity
@Table(name="mechanics")
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mechanicId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false,unique = true)
    private Long employeeNumber ;

    @Column(nullable = false)
    private String name ;

    public Long getId() {return mechanicId;}

    public User getUser() {
        return user;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getEmployeeNumber() {return employeeNumber;}
    public void setEmployeeNumber (Long employeeNumber) {this.employeeNumber = employeeNumber;}

    public String getName() {return name ;}
    public void setName (String name ) {this.name =name ;}

}
