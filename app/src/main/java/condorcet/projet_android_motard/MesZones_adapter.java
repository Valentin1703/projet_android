package condorcet.projet_android_motard;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by krefel on 04-12-17.
 */

public class MesZones_adapter extends ArrayAdapter<Zone>{


    public MesZones_adapter(@NonNull Context context,@LayoutRes int resource) {
        super(context, resource);
    }


    public View getView(int position, @Nullable View converView, @Nullable ViewGroup parent)
    {
        View v;
        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v=layoutInflater.inflate(R.layout.activity_main__meszones_cellule,null);

        Zone currentZone = getItem(position);

        TextView latitude = (TextView)v.findViewById(R.id.id_lati);
        TextView longitude =(TextView)v.findViewById(R.id.id_longi);
        TextView couleur = (TextView)v.findViewById(R.id.id_couleur);

        latitude.setText(String.valueOf(currentZone.getPos_gps_lati()));
        longitude.setText(String.valueOf(currentZone.getPos_gps_long()));


        return v;
    }



}
