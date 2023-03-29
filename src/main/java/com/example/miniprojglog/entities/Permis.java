package com.example.miniprojglog.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permis{
    @Id
    private UUID NumPermis;

    @OneToOne(mappedBy ="permis",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Conducteur  conducteur;


    @OneToMany(mappedBy ="permis",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypePermis> lesPermis;




}
