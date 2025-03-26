package com.example.backend.repositories;

import com.example.backend.entities.HeuresSup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeuresSupRepository extends JpaRepository<HeuresSup, Integer> {
    // You can add custom queries here if needed
}
