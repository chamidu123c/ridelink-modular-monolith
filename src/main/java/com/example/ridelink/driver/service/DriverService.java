package com.example.ridelink.driver.service;

import com.example.ridelink.driver.model.Driver;
import com.example.ridelink.driver.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver createDriver(String name, String vehicleNumber) {
        return driverRepository.save(new Driver(name, vehicleNumber));
    }

    public List<Driver> getAvailableDrivers() {
        return driverRepository.findAll().stream()
                .filter(driver -> driver.isAvailable())
                .toList();
    }

    public Driver changeAvailability(Long id, boolean available) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Driver not found: " + id));
        driver.setAvailable(available);
        return driverRepository.save(driver);
    }
}