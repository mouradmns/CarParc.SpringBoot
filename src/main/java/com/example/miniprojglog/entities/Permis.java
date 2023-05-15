package com.example.miniprojglog.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permis{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long NumPermis;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TypePermis> lesPermis;




}
