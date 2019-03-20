package com.example.shash.earthquake4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    Button mercallisensor,emergencycontacts,emergencysteps,commonalerts,govtalerts,issuealerts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mercallisensor = (Button) findViewById(R.id.esensor);
        emergencycontacts = (Button) findViewById(R.id.econtacts);
        emergencysteps = (Button) findViewById(R.id.esteps);
        commonalerts = (Button)findViewById(R.id.calerts);
        govtalerts = (Button)findViewById(R.id.galerts);
        issuealerts = (Button)findViewById(R.id.ialert);

        // Capture button clicks
        issuealerts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        IssueAlertsMenuActivity.class);
                startActivity(myIntent);
            }
        });
        mercallisensor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        MercalliSensorActivity.class);
                startActivity(myIntent);
            }
        });
        emergencycontacts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        EmergencyContactsActivity.class);
                startActivity(myIntent);
            }
        });
        emergencysteps.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        EmergencyStepsActivity.class);
                startActivity(myIntent);
            }
        });
        commonalerts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        GetCommonAlertsActivity.class);
                startActivity(myIntent);
            }
        });
        govtalerts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(MenuActivity.this,
                        GetGovtAlertsActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
