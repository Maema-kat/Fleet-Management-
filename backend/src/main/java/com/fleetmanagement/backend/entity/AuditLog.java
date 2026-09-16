package com.fleetmanagement.backend.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="auditLogs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private User user ;
    private String action;
    private String entityType;
    private Long entityId;
    private LocalDateTime timestamp;
    private String description;

    public AuditLog () {}
    public AuditLog(Long id ,User user,String action,String entityType,Long entityId,LocalDateTime timestamp,String description) {
        this.id = id ;
        this.user = user;
        this.action =action;
        this.entityType =entityType;
        this.entityId =entityId;
        this.timestamp =timestamp ;
        this.description =description;
    }
    public Long getId() {return id ;}
    public User getUser() {return user;}
    public String getAction () {return action;}
    public String getEntityType() {return entityType;}
    public Long getEntityId(){return entityId;}
    public LocalDateTime getTimestamp() {return timestamp;}
    public String getDescription() {return  description;}

    public void setUser(User user) {this.user = user ;}
    public void setAction(String action) {this.action =action;}
    public void setEntityType(String entityType) {this.entityType =entityType;}
    public void setEntityId (Long entityId){this.entityId = entityId;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp =timestamp;}
    public void setDescription(String description){this.description = description;}

}
