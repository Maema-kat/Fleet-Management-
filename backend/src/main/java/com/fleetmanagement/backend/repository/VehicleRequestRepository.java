package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.VehicleRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRequestRepository extends JpaRepository<VehicleRequest,Long> {
}
