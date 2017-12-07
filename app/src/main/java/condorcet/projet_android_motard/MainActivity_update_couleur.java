package condorcet.projet_android_motard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import retrofit.RestAdapter;


public class MainActivity_update_couleur extends AppCompatActivity
{

    private TextView champdeZone;
    Globals g = Globals.getInstance();
    Button buttonEnregistrer;
    RadioButton Rjaune;
    RadioButton Rrouge;
    RadioButton Rnoir;
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



        champdeZone.setText(getIntent().getSerializableExtra("MainActivity_mes_zones").toString());



        RestAdapter radapter= new RestAdapter.Builder().setEndpoint(url).build();
        restInt=radapter.create(MInterface.class);


    }
    public void OnclickEnregistrer(View v){
    }

}
