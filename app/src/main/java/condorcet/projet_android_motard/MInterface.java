package condorcet.projet_android_motard;


import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;



public interface MInterface {


    @POST("/creapos/")
    void postZone(@Body Zone zone, Callback<Object> id);






 }

