package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.DriverEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
}
