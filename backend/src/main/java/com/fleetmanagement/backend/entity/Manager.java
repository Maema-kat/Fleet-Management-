package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long managerId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(nullable = false)
    private String name ;
    @Column(nullable = false)
    private String department ;

    public Manager(Long managerId, User user, String name, String department) {
        this.managerId = managerId;
        this.user = user;
        this.name = name;
        this.department = department;
    }

    public Long getManagerId() {return managerId;}
    public void setManagerId(Long managerId) {this.managerId=managerId;}

    public User getUser() {
        return user;

    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDepartment() {return department;}
    public void setDepartment (String department) {this.department = department;}

    public String getName() {return name ;}
    public void setName (String name ) {this.name =name ;}

}


