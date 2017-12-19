package condorcet.projet_android_motard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;



@Generated("org.jsonschema2pojo")
public class Zone {


    @SerializedName("id_zone")
    @Expose
    private int id_zone;

    @SerializedName("id_motard")
    @Expose
    private int id_motard;

    @SerializedName("id_couleur")
    @Expose
    private int id_couleur;





    @SerializedName("pos_gps_lati")
    @Expose
    private Double pos_gps_lati;

    @SerializedName("pos_gps_long")
    @Expose
    private Double pos_gps_long;


    public Zone(int id_zone, int id_motard, int id_couleur, Double pos_gps_lati, Double pos_gps_long) {
        this.id_zone = id_zone;
        this.id_motard = id_motard;
        this.id_couleur = id_couleur;
        this.pos_gps_lati = pos_gps_lati;
        this.pos_gps_long = pos_gps_long;
    }


    public Zone(int id_couleur, Double pos_gps_lati, Double pos_gps_long) {
        this.id_couleur = id_couleur;
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

    public int getId_motard() {
        return id_motard;
    }

    public void setId_motard(int id_utilisateur) {
        this.id_motard = id_utilisateur;
    }

    public Double getPos_gps_lati() {
        return pos_gps_lati;
    }

    public void setPos_gps_lati(Double pos_gps_lati) {
        this.pos_gps_lati = pos_gps_lati;
    }

    public Double getPos_gps_long() {
        return pos_gps_long;
    }

    public void setPos_gps_long(Double pos_gps_long) {
        this.pos_gps_long = pos_gps_long;
    }


    @Override
    public String toString()
    {
        String couleur2 = null;

        if(id_couleur==3)
        {
            couleur2="Couleur du danger non défini";
        }
        else if(id_couleur==1)
        {
            couleur2="jaune";
        }
        else if(id_couleur==2)
        {
            couleur2="noir";
        }
        else if (id_couleur==6)
        {
            couleur2="rouge";
        }



        return



                "la zone n°" + id_zone +
                " de couleur : " + couleur2 +
                " à pour latitude : " + pos_gps_lati +
                " et longitude : " + pos_gps_long;
    }
}

