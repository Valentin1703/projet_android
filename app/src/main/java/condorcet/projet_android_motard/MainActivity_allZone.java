package condorcet.projet_android_motard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


import retrofit.RestAdapter;

public class MainActivity_allZone extends AppCompatActivity {

    private ListZone Allzone;
    private String url="https://apex.oracle.com/pls/apex/valentin_workspace/gpos";
    public ListView List_Allzone;

    private MInterface restInt;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_all_zone);

        List_Allzone = (ListView)findViewById(R.id.id_listAll);
        RestAdapter radapter = new RestAdapter.Builder().setEndpoint(url).build();
        restInt = radapter.create(MInterface.class);
        restInt.getAllZone(new Callback<ListZone>()
        {
            ArrayAdapter<String> adapter;


            public void success(ListZone listZone, Response response)
            {

                if(listZone.getItems().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Aucune zone enregistrée par les users ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    List list = listZone.getItems();
                    adapter = new ArrayAdapter<String>(MainActivity_allZone.this, android.R.layout.simple_list_item_1, list);
                    List_Allzone.setAdapter(adapter);

                }
                List_Allzone.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                        Zone zone = (Zone) arg0.getItemAtPosition(arg2);

                        Intent i = new Intent(MainActivity_allZone.this, MainActivity_update_couleur.class);

                        i.putExtra("MainActivity_allZone" ,zone.toString());

                        //startActivity(i);

                    }


                });

            }

            @Override
            public void failure(RetrofitError error) {


                String err = error.getMessage();
                Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                Log.d("TEST: ","ERREUR: "+err);

                Toast.makeText(getApplicationContext(), "fail ", Toast.LENGTH_LONG).show();




            }
        });
    }
}
