package com.example.ridelink.driver.repository;

import com.example.ridelink.driver.model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DriverRepository {

    private final Map<Long, Driver> drivers = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Driver save(Driver driver) {
        if (driver.getId() == null) {
            driver.setId(idGenerator.getAndIncrement());
        }

        drivers.put(driver.getId(), driver);
        return driver;
    }

    public Optional<Driver> findById(Long id) {
        return Optional.ofNullable(drivers.get(id));
    }

    public List<Driver> findAll() {
        return new ArrayList<>(drivers.values());
    }

    // Find all available drivers
    public List<Driver> findByAvailableTrue() {
    List<Driver> availableDrivers = new ArrayList<>();

    for (Driver driver : drivers.values()) {
        if (driver != null && driver.isAvailable()) {
            availableDrivers.add(driver);
        }
    }

    return availableDrivers;
}
}