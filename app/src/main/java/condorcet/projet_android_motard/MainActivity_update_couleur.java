package condorcet.projet_android_motard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity_update_couleur extends AppCompatActivity
{

    private TextView champdeZone;
    Globals g = Globals.getInstance();
    Button buttonEnregistrer;
    RadioButton Rjaune;
    RadioButton Rrouge;
    RadioButton Rnoir;
    Double lati;
    Double longi;
    int id_mot;
    int id_zone=0;
    int new_id_couleur=3;
    //Zone zone;
    private MInterface restInt;
    private String url="https://apex.oracle.com/pls/apex/valentin_workspace/gpos";/*votre repository/votre module";*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update_couleur);
        champdeZone = (TextView) findViewById(R.id.TextZone);
        buttonEnregistrer =(Button) findViewById(R.id.buttonUpdate);
        ListView mesListe_Zone = (ListView) findViewById(R.id.liste_mes_zone);
        Rjaune = (RadioButton) findViewById(R.id.Radiojaune);
        Rrouge = (RadioButton) findViewById(R.id.Radiorouge);
        Rnoir = (RadioButton) findViewById(R.id.Radiorouge);
        RestAdapter radapter= new RestAdapter.Builder().setEndpoint(url).build();
        restInt=radapter.create(MInterface.class);
        //Intent i=
        //String rech = i.getParcelableExtra(Recherche.
        // zone=i.getParcelableExtra("MainActivity_mes_zones".valueOf(zone.toString()));
        champdeZone.setText(getIntent().getSerializableExtra("MainActivity_mes_zones").toString());
        id_mot =g.getData();

        //recuperer juste l'id de la zone, qu'il faut convertir en int
        id_zone= Integer.parseInt(getIntent().getSerializableExtra("MainActivity_mes_zones2").toString());

        lati= Double.valueOf(getIntent().getSerializableExtra("MainActivity_mes_zones3").toString());

        longi= Double.valueOf(getIntent().getSerializableExtra("MainActivity_mes_zones4").toString());

        //affiche bien l'id de la zone selectionnée :)
        Toast.makeText(getApplicationContext(),"Id de la zone :"+id_zone, Toast.LENGTH_LONG).show();




    }


    public void onRadioButtonClicked(View v) {


        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId()) {
            case R.id.Radiojaune:
                if (checked)
                    new_id_couleur=1;
                break;
            case R.id.Radiorouge:
                if (checked)

                    new_id_couleur=6;
                break;

            case R.id.Radionoir:
                if (checked)
                    new_id_couleur=2;

                break;



        }



    }






    public void OnclickEnregistrer(View v){


        final Zone zone = new Zone(id_zone,id_mot,new_id_couleur,lati,longi);



 restInt.update_zone(zone, new Callback<Object>(){


     @Override
     public void success(Object o, Response response) {



         Toast.makeText(getApplicationContext(),"Votre zone est validé", Toast.LENGTH_LONG).show();

     }

     @Override
     public void failure(RetrofitError error) {

         String err = error.getMessage();
         Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
         Toast.makeText(getApplicationContext(), "Une erreur est survenu: "+new_id_couleur, Toast.LENGTH_LONG).show();


     }
 });





    }







}
