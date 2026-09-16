package com.fleetmanagement.backend.service;

import com.fleetmanagement.backend.dto.FuelResponse;
import com.fleetmanagement.backend.dto.FuelRequest;
import com.fleetmanagement.backend.entity.FuelEntity;
import com.fleetmanagement.backend.entity.Vehicle;
import com.fleetmanagement.backend.repository.FuelRepository;
import com.fleetmanagement.backend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelService {
    private final FuelRepository fuelRepository;
    private VehicleRepository vehicleRepository;

    public FuelService(FuelRepository fuelRepository){
        this.fuelRepository = fuelRepository;
    }

    public FuelResponse createFuel(FuelRequest request) {

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        FuelEntity fuel = new FuelEntity();

        fuel.setVehicle(vehicle);
        fuel.setDate(request.getDate());
        fuel.setLiters(request.getLiters());
        fuel.setCost(request.getCost());
        fuel.setOdometer(request.getOdometer());
      ;

        FuelEntity savedFuel = fuelRepository.save(fuel);

        return new FuelResponse(
                savedFuel.getFuelId(),
                savedFuel.getVehicle().getVehicleId(),
                savedFuel.getLiters(),
                savedFuel.getCost(),
                savedFuel.getOdometer(),
                savedFuel.getDate()



        );
    }
    public FuelEntity getFuelId (Long id) {
        return fuelRepository.findById(id).orElseThrow(()-> new RuntimeException("Fuel id not found"));
    }
    public List<FuelEntity> getAllFuels () {
        return fuelRepository.findAll();
    }

}
