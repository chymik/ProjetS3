package org.example;

public class Coffre {
    private int montantActuel;
    private int capaciteMax;

    Coffre(int montantActuel, int capaciteMax){
        this.montantActuel = montantActuel;
        this.capaciteMax = capaciteMax;
    }

    public void ajouterBerrys (int montant) throws CoffrePleinException{
        if (montantActuel + montant > capaciteMax){
            throw new CoffrePleinException("Il n'y a pas assez de place dans ce coffre, tu ne peux pas mettre " + montant + " Berrys dedans.");
        } else {
            montantActuel += montant;
            System.out.println("Vous avez posé " + montant + " Berrys dans votre coffre, en tout vous avez " + montantActuel + " Berrys");
        }
    }

    public void retirerBerrys (int montant){
        if (montantActuel - montant >= 0){
            montantActuel -= montant;
            System.out.println("Vous avez retiré " + montant + " Berrys de votre coffre, il vous reste " + montantActuel + " Berrys");
        } else {
            montantActuel = 0;
            System.out.println("Tu n'as plus de Berrys");
        }
    }

    public int getMontantActuel() {
        return montantActuel;
    }
}
