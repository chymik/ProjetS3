package org.example;

public class Main {
    void main(String[] args) {

        Coffre coffre = new Coffre(0, 500000);
        GestionnaireEquipage equipage = new GestionnaireEquipage(coffre);

        Membre a = new Membre("Damien", Metier.ARCHEOLOGUE);
        Membre b = new Membre("Jorge", Metier.CHARPENTIER);
        Membre c = new Membre("Val", Metier.NAVIGATEUR);
        Membre d = new Membre("Joe", Metier.CUISINIER);

        equipage.recruterMembre(a);
        equipage.recruterMembre(b);
        equipage.recruterMembre(c);
        equipage.recruterMembre(d);

        equipage.afficherEquipage();

        try {
            coffre.ajouterBerrys(100);
        } catch (CoffrePleinException e) {
            System.out.println(e.getMessage());
        }

        coffre.retirerBerrys(1000);
        try {
            coffre.ajouterBerrys(10000000);
        } catch (CoffrePleinException e){
            System.out.println(e.getMessage());
        }

        equipage.sauvegarder("equipage.json");
        equipage.chargerDepuisFichier("equipage.json");
        equipage.afficherEquipage();

    }
}
