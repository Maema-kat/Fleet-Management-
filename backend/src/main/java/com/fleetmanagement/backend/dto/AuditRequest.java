package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.User;

import java.time.LocalDateTime;

public class AuditRequest {
    private Long userId;
    private String action;
    private String entityType;
    private Long entityId;
    private String description;

    public AuditRequest() {
    }
    public String getAction () {return action;}
    public String getEntityType() {return entityType;}
    public Long getEntityId(){return entityId;}
    public Long getUserId() {return  userId;}
    public String getDescription() {return  description;}


    public void setAction(String action) {this.action =action;}
    public void setEntityType(String entityType) {this.entityType =entityType;}
    public void setEntityId (Long entityId){this.entityId = entityId;}
    public void setDescription(String description){this.description = description;}
}
