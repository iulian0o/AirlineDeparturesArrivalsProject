package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
