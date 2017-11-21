package condorcet.projet_android_motard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity_inscription extends AppCompatActivity {

    EditText nom=null;
    EditText prenom=null;
    EditText adresse=null;
    EditText tel=null;
    EditText email=null;
    EditText mdp=null;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inscription);

        nom = (EditText) findViewById(R.id.ednom);
        prenom =(EditText) findViewById(R.id.edprenom);
        adresse= (EditText)findViewById(R.id.edadr);
        tel = (EditText)findViewById(R.id.edtel);
        email = (EditText)findViewById(R.id.edemail);
        mdp =(EditText)findViewById(R.id.edmdp);










    }
}
