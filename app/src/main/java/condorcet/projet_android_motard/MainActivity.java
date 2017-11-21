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

public class MainActivity extends AppCompatActivity {

    /* initialisation des 3 bouton */
    Button inscription = null;
    Button connexion = null;
    Button enregistrer = null;
    private LocationManager locationManager;
    private Zone zone;

    double longitude;
    double latitude;
    boolean onstart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inscription = (Button) findViewById(R.id.btn_inscription);
        connexion = (Button) findViewById(R.id.btn_menu_connexion);
        enregistrer = (Button) findViewById(R.id.btn_save_gps);

        final CheckAutorisations checkPermissions = new CheckAutorisations(this);
        if (!checkPermissions.hasPermissions()) {
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

            //NETWORK_PROVIDER utilise les antennes GSM et le mode COARSE
            LocationListener myLocationListener = getLocationListener();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationListener);
        }catch (SecurityException e) {

            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    public void clickInscription(View v) {
        Intent i = new Intent(MainActivity.this, MainActivity_inscription.class);
        startActivity(i);
    }

    public void clickConnexion(View v) {
        Intent i = new Intent(MainActivity.this, MainActivity_connexion.class);
        startActivity(i);

    }


    public void clickEnregistrer(View v) {
            if(onstart){
                try{
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    Log.i("ONSTART BOUTON CLICK", " " + location.getLatitude() + " " + location.getLongitude());
                }catch (SecurityException e){
                    e.printStackTrace();
                }
                onstart = false;
            }
            else {
                Log.i("BOUTON CLICK  ", "" + longitude + " ---- " + latitude);
            }
    }

    LocationListener getLocationListener(){
       return new LocationListener( ) {

            @Override
            public void onLocationChanged(android.location.Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                final Zone z = new Zone(0, 0, 0, longitude, latitude);


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

}

