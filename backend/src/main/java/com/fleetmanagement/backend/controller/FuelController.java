package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.FuelRequest;
import com.fleetmanagement.backend.dto.FuelResponse;
import com.fleetmanagement.backend.entity.FuelEntity;
import com.fleetmanagement.backend.service.FuelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/fuels")
public class FuelController {
    private final FuelService fuelService;

    public FuelController(FuelService fuelService) {
        this.fuelService = fuelService;
    }

    @PostMapping
    public FuelResponse createFuel(
            @RequestBody FuelRequest request) {

        return fuelService.createFuel(request);
    }
}
