package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.DriverEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {
    boolean existsByLicenseNumber(String licenseNumber);
    Optional<DriverEntity> findByUser_Id(Long userId);
}
