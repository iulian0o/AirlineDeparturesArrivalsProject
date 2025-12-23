package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Data
public class Flight {
    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "first_class_price")
    private BigDecimal firstClassPrice;

    @Column(name = "eco_class_price")
    private BigDecimal ecoClassPrice;

    @ManyToOne
    @JoinColumn(name = "id_plane")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;
}
