package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airport")
@Data
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_airport")
    private Long idAirport;

    @Column(name = "name_airport")
    private String nameAirport;

    @Column(name = "country_airport")
    private String countryAirport;

    @Column(name = "city_airport")
    private String cityAirport;

    private String code;
}