package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.entity.Flight;
import com.Iulian_Jaimie.airline.service.FlightService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) { this.service = service; }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return service.addFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() { return service.getAllFlights(); }

    @GetMapping("/search")
    public List<Flight> searchFlights(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String date) {
        return service.searchFlights(from, to, LocalDate.parse(date));
    }
}