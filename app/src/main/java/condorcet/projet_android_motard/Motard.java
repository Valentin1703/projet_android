package condorcet.projet_android_motard;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;
@Generated("org.jsonschema2pojo")

public class Motard {

    @SerializedName("id_motard")
    @Expose
    private int id_motard;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("email")
    @Expose
    private String mail;
    @SerializedName("adresse")
    @Expose
    private String adresse;
    @SerializedName("password")
    @Expose
    private String mdp;


    public Motard(int id_motard, String nom, String prenom, String mail, String adresse, String mdp) {
        this.id_motard = id_motard;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.mdp = mdp;
    }

    public Motard(String mail, String mdp) {
        this.mail = mail;
        this.mdp = mdp;
    }

    /*  public Motard(String mail, String adresse) {
        this.mail = mail;
        this.adresse = adresse;
    }*/

    public int getId_motard() {
        return id_motard;
    }

    public void setId_motard(int id_motard) {
        this.id_motard = id_motard;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


    @Override
    public String toString() {
        return "Motard{" +
                "id_motard=" + id_motard +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail='" + mail + '\'' +
                ", adresse='" + adresse + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}