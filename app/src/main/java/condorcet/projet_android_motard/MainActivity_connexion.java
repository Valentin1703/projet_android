package condorcet.projet_android_motard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity_connexion extends AppCompatActivity {


    EditText email_connexion = null;
    EditText mdp_connexion = null;
    private String url="https://apex.oracle.com/pls/apex/valentin_workspace/gmot";/*votre repository/votre module";*/
    private MInterface restInt;





    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_connexion);

        email_connexion =(EditText)findViewById(R.id.edemail);
        mdp_connexion =(EditText)findViewById(R.id.edmdp);
    }

    public void connexion(View v){
        restInt.get_log_mdp(email_connexion.getText().toString(),mdp_connexion.getText().toString(),new Callback<Motard>()
        {



            /* si succès on passe retourne a la page d'accueil */
            @Override
            public void success(Motard m , Response response)
            {
                email_connexion.setText(String.valueOf(m.getMail()));
                mdp_connexion.setText(String.valueOf(m.getMdp()));
                Toast.makeText(getApplicationContext(),"Connexion ok ",Toast.LENGTH_LONG).show();

                /* renvoi a la page d'accueil */
                Intent i = new Intent(MainActivity_connexion.this, MainActivity.class);
                startActivity(i);

            }
            /* si echec effacement des champs et on recommence la saisie */
            @Override
            public void failure(RetrofitError error)
            {
                String err = error.getMessage();
                Toast.makeText(getApplicationContext(),err,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"connexion erreur",Toast.LENGTH_LONG).show();
                email_connexion.setText("");
                mdp_connexion.setText("");
            }



        });
    }














}
