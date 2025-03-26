package com.example.backend.controllers;

import com.example.backend.entities.Employe;
import com.example.backend.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {

    private final EmployeService employeService;

    @Autowired
    public EmployeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    // Get all employees
    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.getAllEmployes();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Optional<Employe> getEmployeById(@PathVariable int id) {
        return employeService.getEmployeById(id);
    }

    // Save new employee
    @PostMapping
    public Employe saveEmploye(@RequestBody Employe employe) {
        return employeService.saveEmploye(employe);
    }
}
