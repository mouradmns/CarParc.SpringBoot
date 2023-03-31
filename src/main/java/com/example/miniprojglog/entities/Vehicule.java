package com.example.miniprojglog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {

    @Id
    private Long MatriculeV;

    private String Marque;

    private String Modele;


    @OneToMany(mappedBy = "vehicule")
    private List<Voyage> voyages;
}
