package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {
    List<Maintenance> findByVehicle_Id(Long vehicleId);
}
