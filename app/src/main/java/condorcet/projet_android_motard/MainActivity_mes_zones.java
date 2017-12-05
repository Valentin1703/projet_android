package condorcet.projet_android_motard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;import android.widget.ArrayAdapter;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity_mes_zones extends AppCompatActivity {

    private ListZone mesZone;
    private ListView mesListe_Zone;
    private String url="https://apex.oracle.com/pls/apex/valentin_workspace/gpos";
    Globals g = Globals.getInstance();
    int id = g.getData();
    private MInterface restInt;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mes_zones);
        mesListe_Zone = (ListView) findViewById(R.id.liste_mes_zone);

        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();
        restInt = radapter.create(MInterface.class);
        restInt.getZoneByID(id, new Callback<ListZone>()
        {
        ArrayAdapter<String> adapter;
            @Override
            public void success(ListZone listZone, Response response)
            {
                List listZoneListView =  listZone.getItems();
                adapter = new ArrayAdapter<String>(MainActivity_mes_zones.this,android.R.layout.simple_list_item_1,listZoneListView);
                mesListe_Zone.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error)
            {

            }
        });
    }
}
