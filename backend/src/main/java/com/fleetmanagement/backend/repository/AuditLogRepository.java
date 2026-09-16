package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog,Long> {
}
