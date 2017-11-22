package condorcet.projet_android_motard;



public class Utilisateur {

   private int id_utilisateur;
   private int id_motard;
   private String username;
   private String password;


    public Utilisateur(int id_utilisateur, int id_motard, String username, String password) {
        this.id_utilisateur = id_utilisateur;
        this.id_motard = id_motard;
        this.username = username;
        this.password = password;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_motard() {
        return id_motard;
    }

    public void setId_motard(int id_motard) {
        this.id_motard = id_motard;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
