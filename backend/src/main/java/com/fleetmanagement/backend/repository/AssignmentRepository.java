package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.enums.AssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity,Long > {

    boolean existsByDriverIdAndStatus(Long driverId, AssignmentStatus status);
    boolean existsByVehicleIdAndStatus(Long vehicleId, AssignmentStatus status);
}
