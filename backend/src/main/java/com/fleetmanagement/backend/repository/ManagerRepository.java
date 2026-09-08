package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long>{
}
