package com.example.ridelink.driver.controller;

import com.example.ridelink.driver.model.Driver;
import com.example.ridelink.driver.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Driver create(@RequestBody Driver driver) {
        return driverService.createDriver(
                driver.getName(),
                driver.getVehicleNumber()
        );
    }

    @GetMapping("/available")
    public List<Driver> getAvailable() {
        return driverService.getAvailableDrivers();
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<Driver> changeAvailability(
            @PathVariable Long id,
            @RequestBody Map<String, Boolean> body) {

        Boolean available = body.get("available");

        if (available == null) {
            return ResponseEntity.badRequest().build();
        }

        Driver updated = driverService.changeAvailability(id, available);

        return ResponseEntity.ok(updated);
    }
}