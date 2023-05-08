package com.example.miniprojglog.dtos;

import com.example.miniprojglog.entities.ClassificationPermis;
import lombok.*;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AffectationDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private Long driverId;
    private Long vehicleId;
    private ClassificationPermis typePermis;
}
