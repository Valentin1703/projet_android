package condorcet.projet_android_motard;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

public class MainActivity_inscription extends AppCompatActivity {

    EditText ednom=null;
    EditText edprenom=null;
    EditText edmdp = null;
    EditText edadresse = null;
    EditText edemail = null;
    Button buttonInscription;
    private MInterface restInt;
    private String url = "https://apex.oracle.com/pls/apex/valentin_workspace/gpos";/*votre repository/votre module";*/

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inscription);
        ednom= (EditText) findViewById(R.id.ednom);
        edprenom =(EditText) findViewById(R.id.edprenom);
        edadresse= (EditText)findViewById(R.id.edadr);
        edemail = (EditText)findViewById(R.id.edemail);
        edmdp =(EditText)findViewById(R.id.edmdp);
        buttonInscription = (Button)findViewById(R.id.btn_inscription);
        RestAdapter radapter= new RestAdapter.Builder().setEndpoint(url).build();
        restInt=radapter.create(MInterface.class);
    }


    public void Add_motard(View v)
    {
        String nom = ednom.getText().toString();
        String prenom = edprenom.getText().toString();
        String adresse = edadresse.getText().toString();
        String email = edemail.getText().toString();
        String password = edmdp.getText().toString();

        final Motard motard = new Motard(0,nom,prenom,email,adresse,password);


        restInt.post_ajout_motard(motard, new Callback<Object>() {

            @Override
            public void success(Object id, Response response) {
                int nid = 0;
                for (Header h : response.getHeaders()) {
                    if (h.getName().equals("ID")) {
                        nid = Integer.parseInt(h.getValue());
                        break;
                    }
                }
          //      motard.setId_motard(nid);
           //    ednom.setText(String.valueOf(nid));
                Toast.makeText(getApplicationContext(),"Inscription ok", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity_inscription.this, MainActivity.class);
                startActivity(i);
            }

            @Override
            public void failure(RetrofitError error) {
                String err = error.getMessage();
                Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "inscription fail", Toast.LENGTH_LONG).show();
            }

        });
    }

}
