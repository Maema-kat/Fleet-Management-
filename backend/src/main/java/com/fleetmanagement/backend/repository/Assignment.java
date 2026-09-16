package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Assignment extends JpaRepository<AssignmentEntity,Long > {
}
