package com.example.backend.services;

import com.example.backend.entities.Employe;
import com.example.backend.repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeService(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    // Fetch all employees
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    // Fetch employee by ID
    public Optional<Employe> getEmployeById(int id) {
        return employeRepository.findById(id);
    }

    // Save a new employee
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
}
