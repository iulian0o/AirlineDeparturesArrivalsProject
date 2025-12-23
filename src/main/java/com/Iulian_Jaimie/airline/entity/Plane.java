package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "plane")
@Data
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plane")
    private Long idPlane;

    private String brand;
    private String model;

    @Column(name = "manufacturing_year")
    private Integer manufacturingYear;

    private Integer capacity;
}