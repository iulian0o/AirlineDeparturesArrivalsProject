package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
