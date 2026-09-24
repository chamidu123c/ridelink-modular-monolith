package com.example.ridelink.driver.model;

public class Driver {
    private Long id;
    private String name;
    private String vehicleNumber;
    private boolean available = true;

    public Driver() {
    }

    public Driver(String name, String vehicleNumber) {
        this.name = name;
        this.vehicleNumber = vehicleNumber;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; } 

    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}


