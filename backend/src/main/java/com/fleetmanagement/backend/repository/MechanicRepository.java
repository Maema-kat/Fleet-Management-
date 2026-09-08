package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.Mechanic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRepository extends JpaRepository<Mechanic,Long> {


}
