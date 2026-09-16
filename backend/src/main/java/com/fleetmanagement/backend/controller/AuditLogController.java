package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.AuditRequest;
import com.fleetmanagement.backend.dto.AuditResponse;
import com.fleetmanagement.backend.service.AuditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    private final AuditService auditLogService;

    public AuditLogController(
            AuditService auditLogService) {

        this.auditLogService = auditLogService;
    }

    @PostMapping
    public AuditResponse createAuditLog(
            @RequestBody AuditRequest request) {

        return auditLogService.createAuditLog(request);
    }

    @GetMapping("/{id}")
    public AuditResponse getAuditLogById(
            @PathVariable Long id) {

        return auditLogService.getAuditLogById(id);
    }
}