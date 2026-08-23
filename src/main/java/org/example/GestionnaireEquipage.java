package org.example;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class GestionnaireEquipage {
    private List<Membre> membres;
    private Coffre coffre;

    GestionnaireEquipage(Coffre coffre){
        this.coffre=coffre;
        this.membres=new ArrayList<>();
    }

    public void recruterMembre(Membre m){
        membres.add(m);
    }

    public void afficherEquipage(){
        for (int i = 0; i < membres.size(); i++){
            System.out.println(membres.get(i));
        }
    }

    public Coffre getCoffre() {
        return coffre;
    }

    public List<Membre> getMembres() {
        return membres;
    }

    public void sauvegarder(String cheminFichier) {
        Gson gson = new Gson();
        String json = gson.toJson(membres);
        try {
            Files.writeString(Path.of(cheminFichier), json);
            System.out.println("Équipage sauvegardé dans " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde : " + e.getMessage());
        }
    }

    public void chargerDepuisFichier(String cheminFichier) {
        Gson gson = new Gson();
        try {
            String contenu = Files.readString(Path.of(cheminFichier));
            Type type = new TypeToken<List<Membre>>(){}.getType();
            this.membres = gson.fromJson(contenu, type);
            System.out.println("Équipage chargé depuis " + cheminFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
        }
    }


}
