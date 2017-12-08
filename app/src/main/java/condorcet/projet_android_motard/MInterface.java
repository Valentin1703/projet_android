package condorcet.projet_android_motard;


import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;



public interface MInterface {

  //  public static final String WEBSERVICEURL = "https://apex.oracle.com/pls/apex/valentin_workspace/gmot";


    // ajoute la position GPS dans la bd

   @POST("/creapos/")
    void postZone(@Body Zone zone, Callback<Object> id);


   // recupere toutes les zones en fonction de l'id envoyez

  @GET("/meszones/{id_motard}")
    void getZoneByID(@Path("id_motard") int id, Callback<ListZone> list);

  // crée un nouveau motard (inscription)


@POST("/creamot/")
    void post_ajout_motard(@Body Motard motard, Callback<Object> id);


// connexion du motard avec son email/ mdp

    @GET("/connmot/{email}-{password}")
    void connection_motard(@Path("email") String email,@Path("password")String password, Callback<Motard> motard);

    @POST("/updatezone/")
    void update_zone(@Body Zone zone, Callback<Object> id);


    // select * from zone
    // readall de la table zone


    @GET("/readall/")
    void getAllZone(Callback<ListZone> list);



}





