package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
