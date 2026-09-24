package com.example.ridelink.ride.controller;

import com.example.ridelink.ride.model.Ride;
import com.example.ridelink.ride.service.RideService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    // Request and assign a ride
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ride createRide(@RequestBody Ride ride) {

        return rideService.createRide(
                ride.getPassengerName(),
                ride.getPickup(),
                ride.getDestination()
        );
    }

    // View a ride
    @GetMapping("/{id}")
    public Ride getRide(@PathVariable Long id) {
        return rideService.getRide(id);
    }

    // Complete a ride
    @PatchMapping("/{id}/complete")
    public Ride completeRide(@PathVariable Long id) {
        return rideService.completeRide(id);
    }
}