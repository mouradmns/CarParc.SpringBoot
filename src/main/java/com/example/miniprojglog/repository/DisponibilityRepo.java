package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.entities.Voyage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DisponibilityRepo extends JpaRepository<Voyage, UUID> {

    @Query("SELECT DISTINCT Conducteur  FROM Conducteur c join c.voyages v" +
                " WHERE Conducteur NOT IN (SELECT Conducteur FROM Voyage v WHERE v.DateDebut <= :dateDebut AND v.DateFin >= :dateFin)")
        List<Conducteur> conducteurDisponible(@Param("dateDebut") Date dateDebut,
                                              @Param("dateFin") Date dateFin);

}
