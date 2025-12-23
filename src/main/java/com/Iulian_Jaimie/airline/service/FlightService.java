package com.Iulian_Jaimie.airline.service;

import com.Iulian_Jaimie.airline.entity.Flight;
import com.Iulian_Jaimie.airline.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public Flight addFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    public void deleteFlight(String flightNumber) {
        repository.deleteById(flightNumber);
    }

    public List<Flight> searchFlights(String fromCity, String toCity, LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.atTime(LocalTime.MAX);

        return repository.searchFlights(fromCity, toCity, start, end);
    }
}