package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "miles_reward")
@Data
public class MilesReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reward")
    private Long idReward;

    @Column(name = "date_recorded")
    private LocalDate dateRecorded = LocalDate.now();

    @Column(name = "generated_discount_code")
    private String generatedDiscountCode;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "flight_number")
    private Flight flight;
}
