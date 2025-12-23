package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    @Query("SELECT f FROM Flight f " +
            "WHERE f.departureAirport.cityAirport = :depCity " +
            "AND f.arrivalAirport.cityAirport = :arrCity " +
            "AND f.departureTime BETWEEN :startOfDay AND :endOfDay")
    List<Flight> searchFlights(String depCity, String arrCity, LocalDateTime startOfDay, LocalDateTime endOfDay);
}