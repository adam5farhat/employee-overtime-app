package com.example.backend.repositories;

import com.example.backend.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    // You can add custom queries here if needed
}
