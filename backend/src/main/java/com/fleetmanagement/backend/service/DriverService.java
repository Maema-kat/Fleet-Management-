package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.entity.DriverEntity;
import com.fleetmanagement.backend.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DriverService {

    private final DriverRepository driverRepository;

        public DriverService(DriverRepository driverRepository) {
            this.driverRepository = driverRepository;
        }

        public DriverEntity createDriver(DriverEntity driver) {
            return driverRepository.save(driver);
        }

        public List<DriverEntity> getAllDrivers() {
            return driverRepository.findAll();
        }

        public DriverEntity getDriverById(Long id) {
            return driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
        }

        public DriverEntity updateDriver(Long id, DriverEntity updatedDriver) {

            DriverEntity existingDriver = driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));

            existingDriver.setLicenseNumber(updatedDriver.getLicenseNumber());



            return driverRepository.save(existingDriver);
        }

        public void deleteDriver(Long id) {

            DriverEntity driver = driverRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Driver not found"));

            driverRepository.delete(driver);
        }
    }

