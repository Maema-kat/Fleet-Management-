package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity,Long> {
    boolean existsByStatus(VehicleStatus status);
}
