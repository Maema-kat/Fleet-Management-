package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuelRepository extends JpaRepository<FuelEntity,Long> {
    List<FuelEntity> findByVehicle_Id(Long vehicleId);
}
