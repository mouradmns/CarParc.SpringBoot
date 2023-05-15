package com.example.miniprojglog.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
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
