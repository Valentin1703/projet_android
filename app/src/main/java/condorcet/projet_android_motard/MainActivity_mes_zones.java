package condorcet.projet_android_motard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

                if(listZone.getItems().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Vous n'avez acune zone", Toast.LENGTH_LONG).show();
                }
                else
                {
                    List listZoneListView = listZone.getItems();
                    adapter = new ArrayAdapter<String>(MainActivity_mes_zones.this, android.R.layout.simple_list_item_1, listZoneListView);
                    mesListe_Zone.setAdapter(adapter);

                }


/*
public void success(ListeContactsApex lCont , Response response) {

                if (!lCont.getItems().isEmpty()) {
                    contacts = lCont;
                    ArrayAdapter<ContactApex> adapter = new ArrayAdapter<ContactApex>(Recherche.this, android.R.layout.simple_list_item_1, contacts.getItems());
                    liste_contact.setAdapter(adapter);
                    liste_contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            //arg0:vue groupe,arg1 :vue cliquée,arg2 : position dans le groupe,arg3 : ide de la vue cliquée
                            ContactApex c = (ContactApex) arg0.getItemAtPosition(arg2);
                            /***Tunnel entre l'activité Recherche et AfficheContact**/
               /* Intent i = new Intent(Recherche.this, AfficheContact.class);
                /**Ajout du contact dans l'autre activité*/
   /*             i.putExtra(CONTACT, c);
                /**demarrage de l'activité AfficheContact**/
   /*             startActivity(i);
            }
        });

    }
 */



            }
            @Override
            public void failure(RetrofitError error)
            {
                String err = error.getMessage();
                Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                Log.d("TEST: ","ERREUR: "+err);


                Toast.makeText(getApplicationContext(), "fail ", Toast.LENGTH_LONG).show();




            }
        });
    }
}
