package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity,Long> {
    boolean existsByStatus(VehicleStatus status);
    boolean existsByRegistrationNumber(String registrationNumber);
    List<VehicleEntity> findByStatus(VehicleStatus status);
}
