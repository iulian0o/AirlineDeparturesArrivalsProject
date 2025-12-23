package com.Iulian_Jaimie.airline.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "employee")
@Data
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
    @Column(name = "num_emp", nullable = false, unique = true)
    private String numEmp;

    private String profession;
    private String title;
}