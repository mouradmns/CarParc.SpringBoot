package com.example.miniprojglog.entities;

import jakarta.persistence.*;
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
public class TypePermis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypePermis;
   private LocalDate ExpirationDate;


    @Enumerated(EnumType.STRING)
        private ClassificationPermis typedePermis ;


}
