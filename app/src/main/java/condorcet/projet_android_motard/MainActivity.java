package condorcet.projet_android_motard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
    Button mesZones = null;
    Globals g = Globals.getInstance();
    int id = g.getData();

    private Zone zone;
    private String url = "https://apex.oracle.com/pls/apex/valentin_workspace/gpos";/*votre repository/votre module";*/
    private MInterface restInt;
    private Motard motard;


    // flag for GPS status
    boolean isGPSEnabled = false;
    // flag for network status
    boolean isNetworkEnabled = false;
    // flag for GPS status
    boolean canGetLocation = false;
    Location location = null; // location
    double latitude; // latitude
    double longitude; // longitude
    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1; // 1 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000; // 1 second

    private LocationManager locationManager;
    Activity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesZones = (Button) findViewById(R.id.btn_mesZones);
        inscription = (Button) findViewById(R.id.btn_inscription);
        connexion = (Button) findViewById(R.id.btn_menu_connexion);
        enregistrer = (Button) findViewById(R.id.btn_save_gps);


        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();
        restInt = radapter.create(MInterface.class);


        //  vérifie les autorisations

        final CheckAutorisations checkPermissions = new CheckAutorisations(this);
        if (!checkPermissions.hasPermissions()) {
            checkPermissions.askPermissions();
        }

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                try {
                    if (!isGPSEnabled && !isNetworkEnabled) {
                        // no network provider is enabled
                    } else {
                        canGetLocation = true;
                        if (isNetworkEnabled) {
                            try {
                                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,  MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener());
                            } catch (SecurityException e1) {
                                e1.printStackTrace();
                            }
                            Log.d("Network", "Network Enabled");
                            if (locationManager != null) {
                                try {
                                    location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                                } catch (SecurityException e1) {
                                    e1.printStackTrace();
                                }
                                if (location != null) {
                                    latitude = location.getLatitude();
                                    longitude = location.getLongitude();
                                }
                            }
                        }
                        // if GPS Enabled get lat/long using GPS Services
                        if (isGPSEnabled) {
                            if (location == null) {
                                try {
                                    locationManager.requestLocationUpdates(
                                            LocationManager.GPS_PROVIDER,
                                            MIN_TIME_BW_UPDATES,
                                            MIN_DISTANCE_CHANGE_FOR_UPDATES, locationListener());
                                } catch (SecurityException e1) {
                                    e1.printStackTrace();
                                }
                                Log.d("GPS", "GPS Enabled");
                                if (locationManager != null) {
                                    try {
                                        location = locationManager
                                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                    } catch (SecurityException e1) {
                                        e1.printStackTrace();
                                    }
                                    if (location != null) {
                                        latitude = location.getLatitude();
                                        longitude = location.getLongitude();

                                    }
                                }
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i("POSITION", "" + longitude+ "lat:"+latitude);
                zone = new Zone(0,id,3,latitude,longitude);
                Log.i("Zone = ", zone.toString());
                restInt.postZone(zone, new Callback<Object>()
                {
                    @Override
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
                    public void failure(RetrofitError error)
                    {
                        String err = error.getMessage();
                        Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                        Log.i("ONSTART BOUTON CLICK", " latitude " + zone.getPos_gps_lati() + "longitude  " + zone.getPos_gps_long());
                    }
                });
            }
        }
        );

    }


    public void clickInscription(View v) {
        Intent i = new Intent(MainActivity.this, MainActivity_inscription.class);
        startActivity(i);
    }

    public void clickConnexion(View v) {
        Intent j = new Intent(MainActivity.this, MainActivity_connexion.class);
        startActivity(j);

    }

    public void clickMesZones(View v) {
        Intent y = new Intent(MainActivity.this, MainActivity_mes_zones.class);
        startActivity(y);
    }

    LocationListener locationListener() {
        return new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
    }

}


