package com.example.backend.controllers;

import com.example.backend.entities.HeuresSup;
import com.example.backend.services.HeuresSupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/heures-sup")
public class HeuresSupController {

    private final HeuresSupService heuresSupService;

    @Autowired
    public HeuresSupController(HeuresSupService heuresSupService) {
        this.heuresSupService = heuresSupService;
    }

    // Get all overtime records
    @GetMapping
    public List<HeuresSup> getAllHeuresSup() {
        return heuresSupService.getAllHeuresSup();
    }

    // Get overtime records by employee ID
    @GetMapping("/employe/{id}")
    public List<HeuresSup> getHeuresSupByEmployeId(@PathVariable int id) {
        return heuresSupService.getHeuresSupByEmployeId(id);
    }

    // Save overtime record
    @PostMapping
    public HeuresSup saveHeuresSup(@RequestBody HeuresSup heuresSup) {
        return heuresSupService.saveHeuresSup(heuresSup);
    }

    // Calculate total overtime for an employee within a given period (start and end dates)
    @GetMapping("/employe/{id}/calculate-overtime")
    public double calculateOvertime(
            @PathVariable int id,
            @RequestParam String periodStart, // Start date as a string in "yyyy-MM-dd" format
            @RequestParam String periodEnd    // End date as a string in "yyyy-MM-dd" format
    ) {
        LocalDate start = LocalDate.parse(periodStart);
        LocalDate end = LocalDate.parse(periodEnd);
        return heuresSupService.calculateOvertime(id, start, end);
    }
}
