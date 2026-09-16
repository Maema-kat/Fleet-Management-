package com.fleetmanagement.backend.controller;

import com.fleetmanagement.backend.dto.TripRequest;
import com.fleetmanagement.backend.dto.TripResponse;
import com.fleetmanagement.backend.service.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trips")
public class TripController {



        private final TripService tripService;

        public TripController(TripService tripService) {
            this.tripService = tripService;
        }

        @PostMapping("/start")
        public TripResponse startTrip(
                @RequestBody TripRequest request) {

            return tripService.startTrip(request);
        }

        @PutMapping("/{id}/end")
        public TripResponse endTrip(
                @PathVariable Long id,
                @RequestBody TripRequest tripRequest) {

            return tripService.endTrip(id,tripRequest);
        }
    }

