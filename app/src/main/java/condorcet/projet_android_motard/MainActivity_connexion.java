package condorcet.projet_android_motard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity_connexion extends AppCompatActivity {


    EditText username = null; //j'ai modfifé mail par username
    EditText mdp = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_connexion);


        username =(EditText)findViewById(R.id.edemail);
        mdp =(EditText)findViewById(R.id.edmdp);







    }






}
