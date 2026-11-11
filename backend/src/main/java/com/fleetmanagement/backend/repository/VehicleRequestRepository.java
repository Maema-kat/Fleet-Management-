package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.VehicleRequestEntity;

import com.fleetmanagement.backend.enums.RequestStatus;
import com.fleetmanagement.backend.enums.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRequestRepository extends JpaRepository<VehicleRequestEntity,Long> {
    List<VehicleRequestEntity> findByDriver_Id(Long driverId);
    List<VehicleRequestEntity> findByStatus(RequestStatus status);;
}
