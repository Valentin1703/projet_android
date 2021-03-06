package condorcet.projet_android_motard;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;


public class MainActivity_connexion extends AppCompatActivity {


   private EditText edemail;
    private EditText edpassword;
   // int nid=0;
  Globals g = Globals.getInstance();


    private MInterface restInt;
    private String url="https://apex.oracle.com/pls/apex/valentin_workspace/gmot";/*votre repository/votre module";*/
    private Motard motard;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_connexion);
        edemail =(EditText)findViewById(R.id.email_connexion);
        edpassword =(EditText)findViewById(R.id.mdp_connexion);
        RestAdapter radapter= new RestAdapter.Builder().setEndpoint(url).build();
        restInt=radapter.create(MInterface.class);



    }

    public void ConnMotard(View v){

        String mail = edemail.getText().toString();
        String mdp = edpassword.getText().toString();




            restInt.connection_motard(mail,mdp, new Callback<Motard>() {


                @Override
                public void success(Motard motard, Response response) {

                    Toast.makeText(getApplicationContext(), "Vous êtes connecté", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity_connexion.this, MainActivity.class);
                    g.setData(motard.getId_motard());
                    startActivity(i);



                }

                @Override
                public void failure(RetrofitError error) {
                    String err = error.getMessage();
                    Toast.makeText(getApplicationContext(), err, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Echec de la connexion ", Toast.LENGTH_LONG).show();

                }
            });

        }

    }





