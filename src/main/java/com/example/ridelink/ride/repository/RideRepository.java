package com.example.ridelink.ride.repository;

import com.example.ridelink.ride.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}