package condorcet.projet_android_motard;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {


    /* initialisation des 3 bouton */
    Button inscription = null;
    Button connexion = null;
    Button enregistrer = null;
    private LocationManager locationManager;
    private Zone zone;
    private String url = "https://apex.oracle.com/pls/apex/valentin_workspace/gpos";/*votre repository/votre module";*/
    private MInterface restInt;
    Double longitude;
    Double latitude;
    boolean onstart = true;
    private Motard motard;
    Globals g = Globals.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inscription = (Button) findViewById(R.id.btn_inscription);
        connexion = (Button) findViewById(R.id.btn_menu_connexion);
        enregistrer = (Button) findViewById(R.id.btn_save_gps);
        RestAdapter radapter= new RestAdapter.Builder().setEndpoint(url).build();
        restInt=radapter.create(MInterface.class);


        //  vérifie les autorisations

        final CheckAutorisations checkPermissions = new CheckAutorisations(this);
        if (!checkPermissions.hasPermissions())
        {
            checkPermissions.askPermissions();
        }






        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);
        boolean gps = false;

        for (String name : names) {

            if (name.equals(LocationManager.GPS_PROVIDER)) gps = true;
            Log.d("position", name);
        }

        if (!gps) Toast.makeText(this, "service gps indisponible", Toast.LENGTH_LONG).show();

        else try {
            //Toast.makeText(MainActivity.this, "service gps dispo", Toast.LENGTH_SHORT).show();

            LocationListener myLocationListener = getLocationListener();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationListener);

        } catch (SecurityException e) {

            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }



    // procedure pour envoyer les données GPS a la base de donnée APEX


    public void clickEnregistrer(View v) {

        // recupere l'id du motard qui viens de ce connecter
        int id = g.getData();
        Double tmpLong = 0.0;//c'était juste pour éviter les NullPointeurException
        Double tmpLat =0.0;


        if (onstart) {

            try {
                locationManager = (LocationManager)getSystemService (Context.LOCATION_SERVICE);
                //J'ai mit PASSIVE_PROVIDER à la palce GSP_PROVIDER au lieu de GSP_PROVIDER
                Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);


                tmpLong =  location.getLongitude();
                tmpLat =  location.getLatitude();
                Log.i("ONSTART BOUTON CLICK", " " + tmpLat + " " + tmpLong);

                Toast.makeText(getApplicationContext(), "id du motard : " + id, Toast.LENGTH_LONG).show();



            }



            catch (SecurityException e) {
                e.printStackTrace();
            }



        } else {


            //Toast.makeText(getApplicationContext(), "pas de onstart ", Toast.LENGTH_LONG).show();

            // Toast.makeText(getApplicationContext(), "erreur ", Toast.LENGTH_LONG).show();


            final Zone zone = new Zone(0, id, 3, latitude, longitude);// id = 3 zone ""sans couleur"" 0 donne des soucis de contraintes
            Log.i("BOUTON CLICK", " " + latitude + " " + longitude+" "+id);


            //Toast.makeText(getApplicationContext(), "id du motard : " + id, Toast.LENGTH_LONG).show();

            restInt.postZone(zone, new Callback<Object>() {

                @Override
                // recupere l'id de la zone pr verifier si il c'est bien ajouté.  A supprimer plus tard
                public void success(Object id, Response response) {
                    int nid = 0;
                    for (Header h : response.getHeaders()) {
                        if (h.getName().equals("ID")) {
                            nid = Integer.parseInt(h.getValue());
                            break;
                        }
                    }


                    Toast.makeText(getApplicationContext(), "données gps enregistré dans mes zones ", Toast.LENGTH_LONG).show();
                }

                @Override
                public void failure(RetrofitError error) {
                    String err = error.getMessage();
                    Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                }

            });




        }
    }


    LocationListener getLocationListener() {
        return new LocationListener() {

            @Override
            public void onLocationChanged(android.location.Location location) {
                onstart = false;
                latitude =  location.getLatitude();
                longitude =  location.getLongitude();
            }


            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

        };
    }


    // intent
    public void clickInscription(View v) {
        Intent i = new Intent(MainActivity.this, MainActivity_inscription.class);
        startActivity(i);
    }

    public void clickConnexion(View v) {
        Intent j = new Intent(MainActivity.this, MainActivity_connexion.class);
        startActivity(j);

    }

}
