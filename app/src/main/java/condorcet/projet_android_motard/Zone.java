package condorcet.projet_android_motard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


// @Generated("org.jsonschema2pojo");

public class Zone {


    private int id_zone;


    private int id_couleur;


    private int id_utilisateur;


    private float pos_gps_lati;

    private float pos_gps_long;


    public Zone(int id_zone,int id_couleur, int id_utilisateur, float pos_gps_lati, float pos_gps_long) {
        this.id_zone = id_zone;
        this.id_couleur = id_couleur;
        this.id_utilisateur = id_utilisateur;
        this.pos_gps_lati = pos_gps_lati;
        this.pos_gps_long = pos_gps_long;
    }

    public int getId_zone() {
        return id_zone;
    }

    public void setId_zone(int id_zone) {
        this.id_zone = id_zone;
    }

    public int getId_couleur() {
        return id_couleur;
    }

    public void setId_couleur(int id_couleur) {
        this.id_couleur = id_couleur;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public float getPos_gps_lati() {
        return pos_gps_lati;
    }

    public void setPos_gps_lati(float pos_gps_lati) {
        this.pos_gps_lati = pos_gps_lati;
    }

    public float getPos_gps_long() {
        return pos_gps_long;
    }

    public void setPos_gps_long(float pos_gps_long) {
        this.pos_gps_long = pos_gps_long;
    }


    @Override
    public String toString() {
        return "Zone{" +
                "id_zone=" + id_zone +
                ", id_couleur=" + id_couleur +
                ", id_utilisateur=" + id_utilisateur +
                ", pos_gps_lati=" + pos_gps_lati +
                ", pos_gps_long=" + pos_gps_long +
                '}';
    }
}

