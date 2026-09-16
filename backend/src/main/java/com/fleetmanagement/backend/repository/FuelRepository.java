package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelRepository extends JpaRepository<FuelEntity,Long> {
}
