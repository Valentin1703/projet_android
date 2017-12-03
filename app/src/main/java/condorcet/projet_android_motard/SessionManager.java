/*
package condorcet.projet_android_motard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by lafer on 30-11-17.
 */
/*
public class SessionManager {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "UserInfos";
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_ID_MEMBRE = "id_membre";
    public static final String KEY_NOM = "nom";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PSEUDO = "pseudo";
    public static final String KEY_MDP = "mdp";
    public static final String KEY_LOCALISATION = "localisation";
    public static final String KEY_GROUPE_CHOISI = "groupe_choisi";

    public SessionManager(Context context){
        this._context = context;
        prefs = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = prefs.edit();
    }

    public void createLoginSession(){
        editor.putBoolean(IS_LOGIN,true);
        editor.putInt(KEY_ID_MEMBRE,m.getId_membre());
        editor.putString(KEY_NOM,m.getNom());
        editor.putString(KEY_PRENOM,m.getPrenom());
        editor.putString(KEY_EMAIL,m.getEmail());
        editor.putString(KEY_PSEUDO,m.getPseudo());
        editor.putString(KEY_MDP,m.getMdp());
        editor.commit();
    }

    // definition de méthode set key pour ne pas oublier le commit !
    public void setKeyLocalisation(String localisation){
        editor.putString(KEY_LOCALISATION,localisation);
        editor.commit();
    }
    public void setKeyGroupeChoisi(String groupeChoisi ){
        editor.putString(KEY_GROUPE_CHOISI,groupeChoisi);
        editor.commit();
    }
    public int getKeyIdMembre(){
        return prefs.getInt(KEY_ID_MEMBRE,0);
    }

    public int getKeyIdGroupeChoisi(){
        return Integer.parseInt(prefs.getString(KEY_GROUPE_CHOISI,null));
    }
    public String getKeyPseudo(){return prefs.getString(KEY_PSEUDO,null);}
    // TODO verifier que comme la localisation et le groupe choisi n'est pas défini à la connexion, qu'il ne faut pas rappeler cette méthode une fois ces deux parametres défini
    public HashMap<String,String> getInformations(){
        HashMap<String,String> infos = new HashMap<>();
        infos.put(KEY_ID_MEMBRE,Integer.toString(prefs.getInt(KEY_ID_MEMBRE,0)));
        infos.put(KEY_NOM,prefs.getString(KEY_NOM,null));
        infos.put(KEY_PRENOM,prefs.getString(KEY_PRENOM,null));
        infos.put(KEY_EMAIL,prefs.getString(KEY_EMAIL,null));
        infos.put(KEY_PSEUDO,prefs.getString(KEY_PSEUDO,null));
        infos.put(KEY_MDP,prefs.getString(KEY_NOM,null));
        infos.put(KEY_LOCALISATION,prefs.getString(KEY_NOM,null));
        infos.put(KEY_GROUPE_CHOISI,prefs.getString(KEY_GROUPE_CHOISI,null));
        return infos;
    }
    public void checkLogin(){
        // verif si connecté
        if(!this.isLoggedIn()){
            // redirection vers authentification
            Intent i = new Intent(_context,Authentification.class);
            // Fermes toutes les activités
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Ajout d'un nouveau flag pour démarrer l'activité
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }
    }
    public void logOut(){
        editor.clear();
        editor.commit();
        checkLogin();
    }
    public boolean isLoggedIn(){
        return prefs.getBoolean(IS_LOGIN, false);
    }
}
*/