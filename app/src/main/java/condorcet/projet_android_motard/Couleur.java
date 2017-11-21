package condorcet.projet_android_motard;

/**
 * Created by User on 20-11-17.
 */

public class Couleur {


    private int id_couleur;
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
}
