package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.AssignmentEntity;
import com.fleetmanagement.backend.enums.AssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity,Long > {

    boolean existsByDriver_IdAndStatus(Long driverId, AssignmentStatus status);
    boolean existsByVehicle_IdAndStatus(Long vehicleId, AssignmentStatus status);
    List<AssignmentEntity> findByDriver_Id(Long driverId);
}
