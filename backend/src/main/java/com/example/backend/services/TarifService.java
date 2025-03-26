package com.example.backend.services;

import com.example.backend.entities.Tarif;
import com.example.backend.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifService {

    private final TarifRepository tarifRepository;

    @Autowired
    public TarifService(TarifRepository tarifRepository) {
        this.tarifRepository = tarifRepository;
    }

    // Fetch all tariffs
    public List<Tarif> getAllTarifs() {
        return tarifRepository.findAll();
    }

    // Fetch tariff by ID
    public Optional<Tarif> getTarifById(int id) {
        return tarifRepository.findById(id);
    }

    // Save new tariff
    public Tarif saveTarif(Tarif tarif) {
        return tarifRepository.save(tarif);
    }
}
