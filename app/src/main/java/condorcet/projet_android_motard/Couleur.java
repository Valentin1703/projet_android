package condorcet.projet_android_motard;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
@Generated("org.jsonschema2pojo")
public class Couleur {


    @SerializedName("id_couleur")
    @Expose
    private int id_couleur;
    @SerializedName("nom_couleur")
    @Expose
    private String nom_couleur;


    public Couleur(int id_couleur, String nom_couleur) {
        this.id_couleur = id_couleur;
        this.nom_couleur = nom_couleur;
    }




    public int getId_couleur() {
        return id_couleur;
    }

    public void setId_couleur(int id_couleur) {
        this.id_couleur = id_couleur;
    }

    public String getNom_couleur() {
        return nom_couleur;
    }

    public void setNom_couleur(String nom_couleur) {
        this.nom_couleur = nom_couleur;
    }


    @Override
    public String toString() {
        return "Couleur{" +
                "id_couleur=" + id_couleur +
                ", nom_couleur='" + nom_couleur + '\'' +
                '}';
    }
}


