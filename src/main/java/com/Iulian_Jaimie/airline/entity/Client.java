package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "client")
@Data
@EqualsAndHashCode(callSuper = true)
public class Client extends User {
    @Column(name = "num_passport", nullable = false, unique = true)
    private String numPassport;
}
