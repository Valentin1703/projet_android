package condorcet.projet_android_motard;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;

import condorcet.projet_android_motard.DAO.ZoneDAO;

public class MainActivity extends AppCompatActivity {

    /* initialisation des 3 bouton */
    Button inscription = null;
    Button connexion = null;
    Button enregistrer = null;
    private LocationManager locationManager;
    private Zone zone;

    float longitude;
    float latitude;
    boolean onstart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inscription = (Button) findViewById(R.id.btn_inscription);
        connexion = (Button) findViewById(R.id.btn_menu_connexion);
        enregistrer = (Button) findViewById(R.id.btn_save_gps);


        final CheckAutorisations checkPermissions = new CheckAutorisations(this);
        if (!checkPermissions.hasPermissions())
        {
            checkPermissions.askPermissions();
        }



        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        ArrayList<String> names = (ArrayList<String>) locationManager.getProviders(true);
        boolean gps = false;

        for (String name : names)
        {

            if (name.equals(LocationManager.GPS_PROVIDER)) gps = true;
            Log.d("position", name);
        }

        if (!gps) Toast.makeText(this, "service gps indisponible", Toast.LENGTH_LONG).show();

        else try
        {


            LocationListener myLocationListener = getLocationListener();
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationListener);
        }catch (SecurityException e)
        {

            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }


    public void clickInscription(View v)
    {
        Intent i = new Intent(MainActivity.this, MainActivity_inscription.class);
        startActivity(i);
    }

    public void clickConnexion(View v)
    {
        Intent i = new Intent(MainActivity.this, MainActivity_connexion.class);
        startActivity(i);

    }


    public void clickEnregistrer(View v)
    {
            if(onstart)
            {
                try
                {
                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    float tmpLong = (float) location.getLongitude();
                    float tmpLat = (float) location.getLatitude();
                    Log.i("ONSTART BOUTON CLICK", " " + tmpLat + " " + tmpLong);
                    zone = new Zone(0, 0, 0,tmpLat , tmpLong);
                }catch (SecurityException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                zone = new Zone(0, 0, 0, longitude, latitude);
            }

            InsertZoneAsyncTask insertZoneAsyncTask = new InsertZoneAsyncTask(this,zone);
            insertZoneAsyncTask.execute();
    }

    LocationListener getLocationListener()
    {
       return new LocationListener( ) {

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







    /* AsyncTask */



    class InsertZoneAsyncTask extends AsyncTask<String,Integer,Boolean>
    {
        private Zone z;

        public InsertZoneAsyncTask(MainActivity MainA, Zone z)
        {
            Log.i("ASYNCT ","Constructeur");
            this.z = z;
            link(MainA);
        }

        private void link(MainActivity mainActivity){

        }





        /* désactive le bouton enregistrer une fois que l'on a appuyer dessus, évite ainsi d'enregistrer 2 fois la même position par erreur */
        @Override
        protected void onPreExecute()
        {
            Log.i("ASYNCT ","Disable Button");
            super.onPreExecute();
            enregistrer.setEnabled(false);
        }




        @Override
        protected Boolean doInBackground(String... strings)
        {
            ZoneDAO zdao = new ZoneDAO();
            try{
                Log.i("ASYNCT ","Try call ZoneDAO.create()");
                int i = zdao.create(z);
                if(i < 1 ){
                    Log.i("ASYNCT ","ZoneDAO return false");
                    return false;
                }
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            Log.i("ASYNCT ","ZoneDAO.create() return true");
            return true;
        }



        @Override
        protected void onPostExecute(Boolean resultat)
        {
            super.onPostExecute(resultat);
            enregistrer.setEnabled(true);
            if(resultat)
                Toast.makeText(getApplicationContext(),"Creation reussie",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getApplicationContext(),"Creation échouée",Toast.LENGTH_LONG).show();

        }
    }
}

