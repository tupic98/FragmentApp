package com.example.rafaj.fragmentapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rafaj on 8/4/2018.
 */

public class FragmentViewer extends Fragment {
    private TextView title, description, mindescription;
    private ImageView image;
    private Planet planet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewer_fragment, container, false);

        title = view.findViewById(R.id.titless);
        description = view.findViewById(R.id.desc);
        mindescription = view.findViewById(R.id.mindesc);
        image = view.findViewById(R.id.imageicon);
        Bundle bundle = this.getArguments();


        if(bundle != null){
            planet = bundle.getParcelable("KEY");
            title.setText(planet.getNombre());
            mindescription.setText(planet.getMindescription());
            description.setText(planet.getDescription());
            image.setImageResource(planet.getImage());
        }

        return view;
    }


}
