package com.fleetmanagement.backend.dto;

import com.fleetmanagement.backend.entity.User;

import java.time.LocalDateTime;

public class AuditResponse {


        private Long id;
        private Long userId;
        private String action;
        private String entityType;
        private Long entityId;
        private LocalDateTime timestamp;
        private String description;

        public AuditResponse() {
        }

        public AuditResponse(
                Long id,
                Long userId,
                String action,
                String entityType,
                Long entityId,
                LocalDateTime timestamp,
                String description) {

            this.id = id;
            this.userId = userId;
            this.action = action;
            this.entityType = entityType;
            this.entityId = entityId;
            this.timestamp = timestamp;
            this.description = description;
        }

        public Long getId() {return id ;}
        public Long getUserId() {return userId;}
        public String getAction () {return action;}
        public String getEntityType() {return entityType;}
        public Long getEntityId(){return entityId;}
        public LocalDateTime getTimestamp() {return timestamp;}
        public String getDescription() {return  description;}
    }

