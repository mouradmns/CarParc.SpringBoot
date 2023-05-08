package com.example.miniprojglog;

import com.example.miniprojglog.entities.Vehicle;
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


//    @Bean
    CommandLineRunner start(VehiclesService vheiculeService) {
        return args ->{
            Stream.of("BUS","MiniBus","Car").forEach(name->{

                Vehicle vehicule= new Vehicle();

                Random random=new Random();
                Long randLong=random.nextLong();

                vehicule.setVehicleId(randLong);
                vehicule.setMarque(name);
                vheiculeService.saveVehicule(vehicule);
            } );
        };
    }
//    @Bean
//    CommandLineRunner start(DriverService driverService) {
//        return args -> {
//            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
//                Driver conducteur= new Driver();
//                Random random=new Random();
//                Long randLong=random.nextLong();
//
//                conducteur.setMatriculeC(randLong);
//
//                conducteur.setName(name);
//                conducteur.setPrenom(name + "@gmail.com");
//                driverService.saveDriver(conducteur);
//            } );
//        };
//    }
}


