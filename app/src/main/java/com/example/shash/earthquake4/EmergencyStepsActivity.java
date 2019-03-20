package com.example.shash.earthquake4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmergencyStepsActivity extends AppCompatActivity {

    Button earthquake1,flood1,hurricane1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_steps);

        earthquake1 = (Button) findViewById(R.id.earthquakebutton);
        flood1 = (Button) findViewById(R.id.floodbutton);
        hurricane1 = (Button) findViewById(R.id.hurricanebutton);

        earthquake1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(EmergencyStepsActivity.this,
                        EarthquakeEmergencyStepsActivity.class);
                startActivity(myIntent);

            }
        });
        flood1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(EmergencyStepsActivity.this,
                        FloodEmergencyStepsActivity.class);
                startActivity(myIntent);
            }
        });
        hurricane1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(EmergencyStepsActivity.this,
                        HurricaneEmergencyStepsActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
