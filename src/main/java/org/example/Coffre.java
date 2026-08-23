package org.example;

public class Coffre {
    private int montantActuel;
    private int capaciteMax;

    Coffre(int montantActuel, int capaciteMax){
        this.montantActuel = montantActuel;
        this.capaciteMax = capaciteMax;
    }

    public void ajouterBerrys (int montant)throws CoffrePleinException{
        if (montantActuel + montant > capaciteMax){
            throw new CoffrePleinException("C'est trop rempli, tu peux pas mettre " + montant + " Berrys dedans");
        } else {
            montantActuel += montant;
        }
    }

    public void retirerBerrys (int montant){
        if (montantActuel - montant <= 0){
            montantActuel -= montant;
        } else {
            montantActuel = 0;
            System.out.println("Tu n'as plus de Berrys");
        }
    }

    public int getMontantActuel() {
        return montantActuel;
    }
}
