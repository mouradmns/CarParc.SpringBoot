package com.example.miniprojglog;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.services.ConducteurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class MiniProjGlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjGlogApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ConducteurService conducteurService) {
        return args -> {
            Stream.of("Hassan","Yassine","Aicha").forEach(name->{
                Conducteur  conducteur= new Conducteur();
                int i=0;
                conducteur.setMatriculeC((long) (1+i));
                i++;
                conducteur.setName(name);
                conducteur.setPrenom(name + "@gmail.com");
                conducteurService.saveConducteur(conducteur);

            } );


        };
    }
}


