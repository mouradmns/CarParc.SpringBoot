package com.example.miniprojglog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Conducteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MatriculeC;

    private String Cin;
    private String name;
    private String prenom;
    private Date dateNaissance;
    private Date DateDebutTravail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NumPermis"  )
    private Permis permis;


    @OneToMany(mappedBy = "conducteur")
    private List<Voyage> voyages;
}

