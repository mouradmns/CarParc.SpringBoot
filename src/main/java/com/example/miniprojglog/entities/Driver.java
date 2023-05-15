package com.example.miniprojglog.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorColumn(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driverId;

    private String Cin;
    private String name;
    private String prenom;
    private LocalDate dateNaissance;
    private Date DateDebutTravail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NumPermis"  )
    private Permis permis;


    @JsonBackReference
    @JsonIgnore
    @OneToMany(mappedBy = "driver")
    private List<Trip> tripsD;

    @OneToMany()
    @JsonBackReference
    @JsonIgnore
    private List<Repos> repos;

}

