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
    public String toString() {
        return "Zone{" +
                "id_zone=" + id_zone +
                ", id_couleur=" + id_couleur +
                ", id_utilisateur=" + id_motard +
                ", pos_gps_lati=" + pos_gps_lati +
                ", pos_gps_long=" + pos_gps_long +
                '}';
    }
}

