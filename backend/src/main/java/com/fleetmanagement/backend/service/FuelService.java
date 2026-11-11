package com.fleetmanagement.backend.service;
import com.fleetmanagement.backend.dto.FuelRequest;
import com.fleetmanagement.backend.dto.FuelResponse;
import com.fleetmanagement.backend.entity.FuelEntity;
import com.fleetmanagement.backend.entity.VehicleEntity;
import com.fleetmanagement.backend.exceptions.BusinessRuleException;
import com.fleetmanagement.backend.exceptions.ResourceNotFoundException;
import com.fleetmanagement.backend.repository.FuelRepository;
import com.fleetmanagement.backend.repository.VehicleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FuelService {

    private final FuelRepository fuelRepository;
    private final VehicleRepository vehicleRepository;

    public FuelService(FuelRepository fuelRepository, VehicleRepository vehicleRepository) {
        this.fuelRepository = fuelRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Transactional
    public FuelResponse createFuel(FuelRequest request) {

        VehicleEntity vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (request.getLiters() == null || request.getLiters() <= 0)
            throw new BusinessRuleException("Litres must be greater than zero");
        if (request.getCost() == null || request.getCost() <= 0)
            throw new BusinessRuleException("Fuel cost must be greater than zero");
        if (request.getDate() == null)
            throw new BusinessRuleException("Fuel date is required");
        if (request.getOdometer() == null || request.getOdometer() < vehicle.getMileage())
            throw new BusinessRuleException("Odometer is missing or lower than the vehicle's known mileage");

        FuelEntity fuel = new FuelEntity();
        fuel.setVehicle(vehicle);
        fuel.setDate(request.getDate());
        fuel.setLiters(request.getLiters());
        fuel.setCost(request.getCost());
        fuel.setOdometer(request.getOdometer());

        vehicle.setMileage(request.getOdometer());
        vehicleRepository.save(vehicle);

        FuelEntity saved = fuelRepository.save(fuel);

        return new FuelResponse(
                saved.getFuelId(),
                saved.getVehicle().getId(),      // was getVehicleId()
                saved.getLiters(),
                saved.getCost(),
                saved.getOdometer(),
                saved.getDate());
    }

    public FuelEntity getFuelId(Long id) {
        return fuelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fuel record not found"));
    }

    public List<FuelEntity> getAllFuels() {
        return fuelRepository.findAll();
    }
}