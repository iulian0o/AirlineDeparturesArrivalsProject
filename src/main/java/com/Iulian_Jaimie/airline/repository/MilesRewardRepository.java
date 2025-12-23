package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.MilesReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MilesRewardRepository extends JpaRepository<MilesReward, Long> {

    @Query("SELECT COUNT(m) FROM MilesReward m WHERE m.client.idUser = :clientId AND YEAR(m.dateRecorded) = :year")
    long countFlightsInYear(Long clientId, int year);
}
