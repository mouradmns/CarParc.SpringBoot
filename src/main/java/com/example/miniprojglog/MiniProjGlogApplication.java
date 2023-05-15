package com.example.miniprojglog;


import com.example.miniprojglog.security.auth.AuthenticationService;
import com.example.miniprojglog.security.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.miniprojglog.security.user.Role.ADMIN;

@SpringBootApplication
public class MiniProjGlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjGlogApplication.class, args);
    }

@Bean
public CommandLineRunner commandLineRunner(
        AuthenticationService service
) {
    return args -> {
        var admin = RegisterRequest.builder()
                .firstname("Admin")
                .lastname("Admin")
                .email("admin@mail.com")
                .password("1234")
                .role(ADMIN)
                .build();
        System.out.println("Admin token: " + service.register(admin).getAccessToken());


    };
}
}


