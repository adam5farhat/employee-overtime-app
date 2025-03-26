package com.example.backend.controllers;

import com.example.backend.entities.Tarif;
import com.example.backend.services.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarifs")
public class TarifController {

    private final TarifService tarifService;

    @Autowired
    public TarifController(TarifService tarifService) {
        this.tarifService = tarifService;
    }

    // Get all tariffs
    @GetMapping
    public List<Tarif> getAllTarifs() {
        return tarifService.getAllTarifs();
    }

    // Get tariff by ID
    @GetMapping("/{id}")
    public Optional<Tarif> getTarifById(@PathVariable int id) {
        return tarifService.getTarifById(id);
    }

    // Save new tariff
    @PostMapping
    public Tarif saveTarif(@RequestBody Tarif tarif) {
        return tarifService.saveTarif(tarif);
    }
}
