package com.fleetmanagement.backend.service;


import com.fleetmanagement.backend.dto.AuditRequest;
import com.fleetmanagement.backend.dto.AuditResponse;
import com.fleetmanagement.backend.entity.AuditLog;
import com.fleetmanagement.backend.entity.User;
import com.fleetmanagement.backend.repository.AuditLogRepository;
import com.fleetmanagement.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    private final AuditLogRepository auditLogRepository;
    private final UserRepository userRepository;

    public AuditService(
            AuditLogRepository auditLogRepository,
            UserRepository userRepository) {

        this.auditLogRepository = auditLogRepository;
        this.userRepository = userRepository;
    }

    public AuditResponse createAuditLog(
            AuditRequest request) {

        User user = userRepository.findById(
                request.getUserId()
        ).orElseThrow(() ->
                new RuntimeException("User not found"));

        AuditLog auditLog = new AuditLog();

        auditLog.setUser(user);
        auditLog.setAction(request.getAction());
        auditLog.setEntityType(request.getEntityType());
        auditLog.setEntityId(request.getEntityId());
        auditLog.setTimestamp(LocalDateTime.now());
        auditLog.setDescription(request.getDescription());

        AuditLog savedAuditLog =
                auditLogRepository.save(auditLog);

        return new AuditResponse(
                savedAuditLog.getId(),
                savedAuditLog.getUser().getId(),
                savedAuditLog.getAction(),
                savedAuditLog.getEntityType(),
                savedAuditLog.getEntityId(),
                savedAuditLog.getTimestamp(),
                savedAuditLog.getDescription()
        );
    }

    public AuditResponse getAuditLogById(Long id) {

        AuditLog auditLog =
                auditLogRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Audit log not found"));

        return new AuditResponse(
                auditLog.getId(),
                auditLog.getUser().getId(),
                auditLog.getAction(),
                auditLog.getEntityType(),
                auditLog.getEntityId(),
                auditLog.getTimestamp(),
                auditLog.getDescription()
        );
    }
}
