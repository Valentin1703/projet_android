package condorcet.projet_android_motard.DAO;

import android.util.JsonWriter;

import com.sun.jersey.api.client.ClientResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import javax.ws.rs.core.MultivaluedMap;

import condorcet.projet_android_motard.Zone;

/**
 * Created by lafer on 21-11-17.
 */

public class ZoneDAO extends BaseDAO implements DAO<Zone> {
    @Override
    public ArrayList<Zone> readAll() {
        return null;
    }
    @Override
    public Zone readById() {
        return null;
    }

    @Override
    public int create(Zone zone) {
        int id_zone = 0;
        System.out.println("--- Create Zone method ---");
        json = "";
        try{
           JSONObject jo = new JSONObject();
           try{
               jo.put("id_zone",zone.getId_zone());
               jo.put("id_utilisateur",zone.getId_utilisateur());
               jo.put("id_couleur",zone.getId_couleur());
               jo.put("pos_gps_lati",zone.getPos_gps_lati());
               jo.put("pos_gps_long",zone.getPos_gps_long());
               json = jo.toString();
           }catch (JSONException e){
               e.printStackTrace();
           }
            System.out.println("zone to json : " + json);
        }catch (Exception e){
            e.printStackTrace();
        }
        response = service.path("gpos").path("creapos/").type("application/json").post(ClientResponse.class,json);
        int status = response.getStatus();
        MultivaluedMap header = response.getHeaders();
        if(status >= 400){
            System.err.println("erreur status " + status);
            //ouin ouin
            System.err.println(header.getFirst("Error-Reason"));
        }
        else{
            System.out.println();
        }
        System.out.println("Paramètre retourné : " + header.getFirst("id_zone"));
        id_zone = Integer.parseInt(header.getFirst("id_zone").toString());
        return id_zone;
    }

}
