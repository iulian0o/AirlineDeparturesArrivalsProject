package com.Iulian_Jaimie.airline.repository;

import com.Iulian_Jaimie.airline.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}