package com.Iulian_Jaimie.airline.service;

import com.Iulian_Jaimie.airline.entity.Airport;
import com.Iulian_Jaimie.airline.repository.AirportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirportService {
    private final AirportRepository repository;

    public AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public Airport addAirport(Airport airport) {
        return repository.save(airport);
    }

    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    public void deleteAirport(Long id) {
        repository.deleteById(id);
    }
}