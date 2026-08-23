package org.example;

public class Membre {
    private String nom;
    private Metier metier;

    Membre(String nom, Metier metier){
        this.nom = nom;
        this.metier = metier;
    }

    public String getNom() {
        return nom;
    }

    public Metier getMetier() {
        return metier;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Metier: " + metier;
    }
}
