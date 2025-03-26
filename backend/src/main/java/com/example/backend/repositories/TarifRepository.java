package com.example.backend.repositories;

import com.example.backend.entities.Tarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Integer> {
    // You can add custom queries here if needed
}
