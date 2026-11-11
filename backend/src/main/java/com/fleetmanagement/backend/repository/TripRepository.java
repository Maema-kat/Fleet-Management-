package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.TripEntity;
import com.fleetmanagement.backend.enums.TripStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<TripEntity,Long> {
    boolean existsByAssignment_Vehicle_IdAndStatus(Long vehicleId, TripStatus status);
    List<TripEntity> findByAssignment_Id(Long assignmentId);
}
