package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.VehicleRequestEntity;

import com.fleetmanagement.backend.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRequestRepository extends JpaRepository<VehicleRequestEntity,Long> {
    boolean existsByStatus(VehicleStatus status);
}
