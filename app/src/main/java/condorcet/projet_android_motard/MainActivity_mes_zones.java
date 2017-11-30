package condorcet.projet_android_motard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity_mes_zones extends AppCompatActivity {

    private ArrayList<Zone> mesZone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mes_zones);

        mesZone = new ArrayList<>();




    }
}
