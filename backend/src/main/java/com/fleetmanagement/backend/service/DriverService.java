package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.entity.Driver;
import com.fleetmanagement.backend.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DriverService {

    private final DriverRepository driverRepository;

        public DriverService(DriverRepository driverRepository) {
            this.driverRepository = driverRepository;
        }

        public Driver createDriver(Driver driver) {
            return driverRepository.save(driver);
        }

        public List<Driver> getAllDrivers() {
            return driverRepository.findAll();
        }

        public Driver getDriverById(Long id) {
            return driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
        }

        public Driver updateDriver(Long id, Driver updatedDriver) {

            Driver existingDriver = driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));

            existingDriver.setLicenseNumber(updatedDriver.getLicenseNumber());
            existingDriver.setExpiryDate(updatedDriver.getLicenseNumber());


            return driverRepository.save(existingDriver);
        }

        public void deleteDriver(Long id) {

            Driver driver = driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));

            driverRepository.delete(driver);
        }
    }

