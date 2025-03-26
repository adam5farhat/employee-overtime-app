package com.example.backend.services;

import com.example.backend.entities.HeuresSup;
import com.example.backend.entities.Tarif;
import com.example.backend.repositories.HeuresSupRepository;
import com.example.backend.repositories.TarifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HeuresSupService {

    private final HeuresSupRepository heuresSupRepository;
    private final TarifRepository tarifRepository;

    @Autowired
    public HeuresSupService(HeuresSupRepository heuresSupRepository, TarifRepository tarifRepository) {
        this.heuresSupRepository = heuresSupRepository;
        this.tarifRepository = tarifRepository;
    }

    // Fetch all overtime records
    public List<HeuresSup> getAllHeuresSup() {
        return heuresSupRepository.findAll();
    }

    // Save overtime record
    public HeuresSup saveHeuresSup(HeuresSup heuresSup) {
        return heuresSupRepository.save(heuresSup);
    }

    // Fetch overtime by employee ID
    public List<HeuresSup> getHeuresSupByEmployeId(int employeId) {
        return heuresSupRepository.findAll().stream()
                .filter(heures -> heures.getEmploye().getId() == employeId)
                .toList();
    }

    // Calculate total overtime for an employee in a given period
    public double calculateOvertime(int employeId, LocalDate periodStart, LocalDate periodEnd) {
        List<HeuresSup> heuresSupList = getHeuresSupByEmployeId(employeId);

        // Sum up the total overtime hours within the given period
        double totalOvertimeHours = 0;
        for (HeuresSup heuresSup : heuresSupList) {
            if ((heuresSup.getDate().isAfter(periodStart) || heuresSup.getDate().isEqual(periodStart)) &&
                    (heuresSup.getDate().isBefore(periodEnd) || heuresSup.getDate().isEqual(periodEnd))) {
                totalOvertimeHours += heuresSup.getNbHeures();
            }
        }

        // Fetch the employee's tariff (assuming there is only one tariff for simplicity)
        Optional<Tarif> tarifOpt = tarifRepository.findById(1); // Replace with actual logic if necessary
        if (tarifOpt.isPresent()) {
            Tarif tarif = tarifOpt.get();
            // Calculate the overtime pay (1.5x the regular rate for overtime)
            double overtimeRate = tarif.getHeureNormale() * 1.5;
            return totalOvertimeHours * overtimeRate;
        }

        return 0; // Return 0 if no tariff found
    }
}
