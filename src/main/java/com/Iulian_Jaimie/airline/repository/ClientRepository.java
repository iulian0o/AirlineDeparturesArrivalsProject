package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNumPassport(String numPassport);
}