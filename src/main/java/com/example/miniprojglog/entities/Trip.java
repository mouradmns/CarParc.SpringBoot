package com.example.miniprojglog.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  tripId;

    private LocalDate DateDebut;
    private LocalDate DateFin;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

}
