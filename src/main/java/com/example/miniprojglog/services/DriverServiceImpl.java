package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.repository.DriverRepo;
import com.example.miniprojglog.services.Interfaces.DriverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class DriverServiceImpl implements DriverService {

    DriverRepo driverRepo;

    @Override
    public Driver saveDriver(Driver driver) {

        return driverRepo.save(driver);
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public Driver deleteDriver(Long matriculeC) {
        Driver toDeleteCOnd= driverRepo.getReferenceById(matriculeC);
        driverRepo.delete(toDeleteCOnd);
        return toDeleteCOnd;
    }

    @Override
    public Optional<Driver> getDriverById(Long matriculeC) {
        log.info("+++++++++++++inside the getdrivers Service() method ");
        return driverRepo.findById(matriculeC);    }



    @Override
    public List<Driver> listDrivers() {
        log.info("+++++++++++++inside the Listdrivers() method ");
        return driverRepo.findAll();
    }
}

