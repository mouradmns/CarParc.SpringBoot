package com.example.miniprojglog.web;
import com.example.miniprojglog.dtos.AffectationDto;
import com.example.miniprojglog.entities.ClassificationPermis;
import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.exeptions.DriverNotAvailableException;
import com.example.miniprojglog.exeptions.DriverNotConformedException;
import com.example.miniprojglog.exeptions.VehicleNotAvailableException;
import com.example.miniprojglog.services.AffectationServiceImpl;
import com.example.miniprojglog.services.VehiculeNotConformedException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@Data
@Slf4j
public class AffectationController {

    AffectationServiceImpl affectationService;


    @PostMapping("/affectation")
    public Trip affectation(@RequestBody AffectationDto affectationDto) throws DriverNotAvailableException, VehicleNotAvailableException, DriverNotConformedException, VehiculeNotConformedException {
        log.info("++++++++++++Starting date"+affectationDto.toString());
        return affectationService.affectation(affectationDto.getStartDate(), affectationDto.getEndDate(), affectationDto.getDriverId().longValue(), affectationDto.getVehicleId().longValue(),affectationDto.getTypePermis());
    }

}
