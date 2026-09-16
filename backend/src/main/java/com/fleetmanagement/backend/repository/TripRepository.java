package com.fleetmanagement.backend.repository;

import com.fleetmanagement.backend.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<TripEntity,Long> {
}
