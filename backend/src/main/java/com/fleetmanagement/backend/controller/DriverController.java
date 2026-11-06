package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.entity.DriverEntity;
import com.fleetmanagement.backend.service.DriverService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/drivers")
    public class DriverController {

        private final DriverService driverService;

        public DriverController(DriverService driverService) {
            this.driverService = driverService;
        }

        @PostMapping
        public DriverEntity createDriver(@RequestBody DriverEntity driver) {
            return driverService.createDriver(driver);
        }

        @GetMapping
        public List<DriverEntity> getAllDrivers() {
            return driverService.getAllDrivers();
        }

        @GetMapping("/{id}")
        public DriverEntity getDriverById(@PathVariable Long id) {
            return driverService.getDriverById(id);
        }

        @PutMapping("/{id}")
        public DriverEntity updateDriver(
                @PathVariable Long id,
                @RequestBody DriverEntity driver) {

            return driverService.updateDriver(id, driver);
        }

        @DeleteMapping("/{id}")
        public void deleteDriver(@PathVariable Long id) {
            driverService.deleteDriver(id);
        }
    }

