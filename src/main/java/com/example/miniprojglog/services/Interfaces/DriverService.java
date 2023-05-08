package com.example.miniprojglog.services.Interfaces;

import com.example.miniprojglog.entities.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DriverService {
    Driver saveDriver(Driver driver);
    Driver updateDriver(Driver driver);
    Driver deleteDriver(Long matriculeC);

    Optional<Driver> getDriverById(Long matriculeC);

     List<Driver>  listDrivers();

 }
