package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DisponibilityRepo extends JpaRepository<Trip, UUID> {

    @Query("SELECT DISTINCT Driver  FROM Driver d join d.trips t" +
                " WHERE Driver NOT IN (SELECT Driver FROM Trip t WHERE t.DateDebut <= :dateDebut AND t.DateFin >= :dateFin)")
        List<Driver> disponibleDrivers(@Param("dateDebut") LocalDate dateDebut,
                                       @Param("dateFin") LocalDate dateFin);


    @Query("SELECT DISTINCT Driver  FROM Driver d join d.trips v" +
            " WHERE d.driverId =:matriculeC AND Driver NOT IN (SELECT Driver FROM Trip v WHERE v.DateDebut <= :dateDebut AND v.DateFin >= :dateFin)")
    Driver disponibleDriver(@Param("matriculeC") Long matriculeC,
                                @Param("dateDebut") LocalDate dateDebut,
                                @Param("dateFin") LocalDate dateFin);

}
