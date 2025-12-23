package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate = LocalDateTime.now();

    @Column(name = "seat_type")
    private String seatType;

    @ManyToOne
    @JoinColumn(name = "flight_number")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
