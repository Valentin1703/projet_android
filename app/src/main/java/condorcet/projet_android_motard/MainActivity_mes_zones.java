package condorcet.projet_android_motard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity_mes_zones extends AppCompatActivity {

    private ArrayList<Zone> mesZone;
    private ListView mesListe_Zone;
    private MesZones_adapter mesZones_adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mes_zones);
/*
        mesZone = new ArrayList<>();

        mesListe_Zone = (ListView)findViewById(R.id.liste_mes_zone);

        mesZones_adapter = new MesZones_adapter(getApplicationContext(),0);


        mesZone.add(new Zone(0,0,0,5464.5,464.1));
        mesZone.add(new Zone(0,0,0,546165.0,4654654.0));
        //mesZones.add(new Zone())
        //mesZones.add(new Zone())
        //mesZones.add(new Zone())





        mesListe_Zone.setAdapter(mesZones_adapter);

        mesZones_adapter.addAll(mesZone);

*/

    }
}
