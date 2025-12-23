package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.entity.Airport;
import com.Iulian_Jaimie.airline.service.AirportService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/airports")
@CrossOrigin(origins = "*")
public class AirportController {
    private final AirportService service;

    public AirportController(AirportService service) { this.service = service; }

    @PostMapping
    public Airport addAirport(@RequestBody Airport airport) {
        return service.addAirport(airport);
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return service.getAllAirports();
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id) {
        service.deleteAirport(id);
    }
}