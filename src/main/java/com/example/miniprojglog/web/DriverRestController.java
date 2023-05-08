package com.example.miniprojglog.web;


import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.services.Interfaces.DriverService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
public class DriverRestController {


    @Autowired
    private DriverService driverService;



    @GetMapping("/drivers")
    public List<Driver> drivers()

    {
        log.info("+++++++++++++inside the drivers() method ");
        return driverService.listDrivers();
    }
    @GetMapping("/drivers/{id}")
    public Optional<Driver> getDriver(@PathVariable Long id) {
        log.info("+++++++++++++inside the getdriver() method ");
        Optional<Driver> condById= driverService.getDriverById(id);
        log.info(condById.toString());
        return condById;
    }

    @PostMapping("/driver")
    public ResponseEntity<Driver> saveDriver(@RequestBody Driver driver) {

        Driver savedDriver = driverService.saveDriver(driver);

        return ResponseEntity.ok(savedDriver);
    }





    @PutMapping("/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        driver.setDriverId(id);
        Driver updatedDriver = driverService.updateDriver(driver);
        return ResponseEntity.ok(updatedDriver);
    }



    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<Driver> deleteConducteur(@PathVariable Long conducteurId) {
        Driver deletedCond= driverService.deleteDriver(conducteurId);
        return ResponseEntity.ok(deletedCond);
    }
}
