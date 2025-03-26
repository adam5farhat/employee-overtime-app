package com.example.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class HeuresSup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    private LocalDate date;  // Change to LocalDate for better date handling
    private double nbHeures; // Renamed to match Java naming conventions

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(double nbHeures) {
        this.nbHeures = nbHeures;
    }


    @Override
    public String toString() {
        return "HeuresSup{" +
                "id=" + id +
                ", employe=" + employe.getNom() + " " + employe.getPrenom() +
                ", date=" + date +
                ", nbHeures=" + nbHeures +
                '}';
    }
}
