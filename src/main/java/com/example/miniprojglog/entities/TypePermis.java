package com.example.miniprojglog.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypePermis {

    @Id
    private UUID idTypePermis;

    private Date DateObtention;

    Short DureeDeVie;

    @Enumerated(EnumType.STRING)
    @Column(name = "my_tpe")
    private ClassificationPermis typedePermis ;

    @ManyToOne(fetch = FetchType.LAZY)
     private Permis permis;


}
