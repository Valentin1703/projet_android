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
    float longitude;
    float latitude;
    boolean onstart = true;
    private Motard motard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inscription = (Button) findViewById(R.id.btn_inscription);
        connexion = (Button) findViewById(R.id.btn_menu_connexion);
        enregistrer = (Button) findViewById(R.id.btn_save_gps);


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


            LocationListener myLocationListener = getLocationListener();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationListener);
        } catch (SecurityException e) {

            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }



        // procedure pour envoyer les données GPS a la base de donnée APEX

    public void clickEnregistrer(View v) {

        // recupere l'id du motard qui viens de ce connecter
        int id = motard.getId_motard();


        if (onstart) {
            try {
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                float tmpLong = (float) location.getLongitude();
                float tmpLat = (float) location.getLatitude();
                Log.i("ONSTART BOUTON CLICK", " " + tmpLat + " " + tmpLong);


                Toast.makeText(getApplicationContext(), "id du motard : " + id, Toast.LENGTH_LONG).show();


                zone = new Zone(0, id, 0, tmpLat, tmpLong);
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        } else {
            final Zone zone = new Zone(0, id, 0, latitude, longitude);

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
                latitude = (float) location.getLatitude();
                longitude = (float) location.getLongitude();
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
