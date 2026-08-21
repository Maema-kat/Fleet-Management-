package com.fleetmanagement.backend.repository;
import com.fleetmanagement.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long>{
}
