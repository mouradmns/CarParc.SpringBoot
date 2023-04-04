package com.example.miniprojglog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    private Long  tripId;

    private LocalDate DateDebut;
    private LocalDate DateFin;


    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

}
