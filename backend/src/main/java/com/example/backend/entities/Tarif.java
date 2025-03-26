package com.example.backend.entities;

import jakarta.persistence.*;


@Entity
public class Tarif {

    @Id
    private int id;

    private String typeJour; // "weekend" or "jour ordinaire"
    private double tarif; // Regular hourly rate

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeJour() {
        return typeJour;
    }

    public void setTypeJour(String typeJour) {
        this.typeJour = typeJour;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    // Assuming "heureNormale" is the regular hourly rate
    public double getHeureNormale() {
        return tarif; // Assuming the 'tarif' field represents the regular hourly rate
    }

    @Override
    public String toString() {
        return "Tarif{" +
                "id=" + id +
                ", typeJour='" + typeJour + '\'' +
                ", tarif=" + tarif+ '\'' +
                '}';    }
}
