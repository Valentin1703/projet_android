package condorcet.projet_android_motard;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;



public interface MInterface {


    /* ajouter dans la bd la position GPS */
   @POST("/creapos/")
    void postZone(@Body Zone zone, Callback<Object> id);

    /* crée un motard */
@POST("/creamot/")
    void post_ajout_motard(@Body Motard motard, Callback<Object> id);

    /* vérifier que l'user a bien un mail/mdp ds la bd (un compte ) */
    @GET("connmot/{email}-{password}")
    void get_log_mdp(@Path("email")String email,@Path("password")String password,Callback<Motard> motard);



 }

