package com.example.miniprojglog.repository;

import com.example.miniprojglog.entities.Driver;
import com.example.miniprojglog.entities.Trip;
import com.example.miniprojglog.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface DisponibilityRepo extends JpaRepository<Trip, Long> {

    //query to return a disponible driver
    @Query("SELECT DISTINCT d  FROM Driver d " +
            "WHERE d.driverId = :matriculeC " +
            "AND  d.driverId NOT In " +
            "(SELECT  t.driver.driverId FROM Trip t WHERE t.driver.driverId =:matriculeC " +
            " AND ((:dateDebut between t.DateDebut and t.DateFin) OR (:dateFin between t.DateDebut and t.DateFin)))"
    )
    Driver disponibleDriver(@Param("matriculeC") Long matriculeC,
                            @Param("dateDebut") LocalDate dateDebut,
                            @Param("dateFin") LocalDate dateFin);


    //query to return a disponible vehicle
    @Query("SELECT DISTINCT v FROM  Vehicle v" +
            " WHERE v.vehicleId = :matriculeV " +
            "AND  v.vehicleId NOT In " +
            "(SELECT  t.vehicle.vehicleId FROM Trip t WHERE t.vehicle.vehicleId=:matriculeV " +
            " AND ((:dateDebut between t.DateDebut and t.DateFin) OR (:dateFin between t.DateDebut and t.DateFin)))"
    )
    Vehicle disponibleVehicle(@Param("matriculeV") Long matriculeV,
                              @Param("dateDebut") LocalDate dateDebut,
                              @Param("dateFin") LocalDate dateFin);







    // list of all  disponible drivers :
    @Query("SELECT  d  FROM Driver d " +
            " Where  d.driverId NOT In " +
            "(SELECT  t.driver.driverId FROM Trip t WHERE t.driver.driverId =:matriculeC " +
            " AND ((:dateDebut between t.DateDebut and t.DateFin) OR (:dateFin between t.DateDebut and t.DateFin)))"
    )
    List<Driver> disponibleDrivers(@Param("dateDebut") LocalDate dateDebut,
                                       @Param("dateFin") LocalDate dateFin);




    // list of all  disponible Vehicles :
    @Query("SELECT DISTINCT v FROM  Vehicle v" +
            " WHERE  v.vehicleId NOT In " +
            "(SELECT  t.vehicle.vehicleId FROM Trip t WHERE t.vehicle.vehicleId=:matriculeV " +
            " AND ((:dateDebut between t.DateDebut and t.DateFin) OR (:dateFin between t.DateDebut and t.DateFin)))"
    )
    List<Vehicle> disponibleVehicles(@Param("dateDebut") LocalDate dateDebut,
                                     @Param("dateFin") LocalDate dateFin);





}
