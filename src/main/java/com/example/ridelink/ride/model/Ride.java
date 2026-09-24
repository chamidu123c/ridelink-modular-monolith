package com.example.ridelink.ride.model;
import jakarta.persistence.*;

@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private String pickup;
    private String destination;
    private Long driverId;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    public Ride() {
    }

    public Ride(String passengerName, String pickup, String destination) {
        this.passengerName = passengerName;
        this.pickup = pickup;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
    }

    public Long getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDestination() {
        return destination;
    }

    public Long getDriverId() {
        return driverId;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }
}