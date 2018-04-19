package com.example.rafaj.fragmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView title, desc, mindesc;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        title = findViewById(R.id.titless);
        mindesc = findViewById(R.id.mindesc);
        desc = findViewById(R.id.desc);
        image = findViewById(R.id.imageicon);

        Intent callingIntent = getIntent();
        String intentAction = callingIntent.getAction();
        String intentType = callingIntent.getType();

        handleReceivedText(callingIntent);

    }

    private void handleReceivedText(Intent intent){
        Planet planet = intent.getExtras().getParcelable("KEY");

        if (title != null && mindesc != null && desc != null){
            title.setText(planet.getNombre());
            mindesc.setText(planet.getMindescription());
            desc.setText(planet.getDescription());
            image.setImageResource(planet.getImage());
        }
    }
}
