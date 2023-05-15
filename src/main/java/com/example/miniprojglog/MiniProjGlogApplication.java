package com.example.miniprojglog;

import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.entities.Vehicle;
import com.example.miniprojglog.services.Interfaces.TripService;
import com.example.miniprojglog.services.Interfaces.VehiclesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class MiniProjGlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjGlogApplication.class, args);
    }

}


