package com.example.ridelink.ride.service;

import com.example.ridelink.driver.model.Driver;
import com.example.ridelink.driver.repository.DriverRepository;
import com.example.ridelink.ride.model.Ride;
import com.example.ridelink.ride.model.RideStatus;
import com.example.ridelink.ride.repository.RideRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;
    private final DriverRepository driverRepository;

    public RideService(RideRepository rideRepository,
                       DriverRepository driverRepository) {
        this.rideRepository = rideRepository;
        this.driverRepository = driverRepository;
    }

    public Ride createRide(String passengerName,
                           String pickup,
                           String destination) {

        List<Driver> drivers = driverRepository.findByAvailableTrue();

        if (drivers.isEmpty()) {
            throw new IllegalStateException("No driver available");
        }

        Driver driver = drivers.get(0);

        driver.setAvailable(false);
        driverRepository.save(driver);

        Ride ride = new Ride(passengerName, pickup, destination);

        ride.setDriverId(driver.getId());
        ride.setStatus(RideStatus.ASSIGNED);

        return rideRepository.save(ride);
    }
    public Ride getRide(Long id) {

    return rideRepository.findById(id)
            .orElseThrow(() ->
                    new IllegalArgumentException("Ride not found: " + id));
}

    public Ride completeRide(Long id) {

        Ride ride = rideRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Ride not found"));

        Driver driver = driverRepository.findById(ride.getDriverId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Driver not found"));

        ride.setStatus(RideStatus.COMPLETED);

        driver.setAvailable(true);
        driverRepository.save(driver);

        return rideRepository.save(ride);
    }
}