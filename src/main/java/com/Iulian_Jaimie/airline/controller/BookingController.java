package com.Iulian_Jaimie.airline.controller;

import com.Iulian_Jaimie.airline.service.BookingService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) { this.service = service; }

    @PostMapping
    public String bookFlight(@RequestBody BookingRequest request) {
        return service.createBooking(
                request.getLastname(),
                request.getFirstname(),
                request.getPassportNumber(),
                request.getFlightNumber(),
                request.getSeatType()
        );
    }

    @Data
    public static class BookingRequest {
        private String firstname;
        private String lastname;
        private String passportNumber;
        private String birthdate;
        private String departureCity;
        private String arrivalCity;
        private String flightNumber;
        private String seatType;
    }
}