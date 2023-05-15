package com.example.miniprojglog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Entity
public class TechnicalVisit {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long  TechnicalVisitId;
        private LocalDate StartDate;

    }
