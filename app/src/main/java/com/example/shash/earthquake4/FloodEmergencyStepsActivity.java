package com.example.shash.earthquake4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FloodEmergencyStepsActivity extends AppCompatActivity {
    Button issuealert1,emergencycontacts1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood_emergency_steps);
        issuealert1 = (Button)findViewById(R.id.issuealertbutton1);
        emergencycontacts1 = (Button) findViewById(R.id.emergencycontactsbutton1);
        issuealert1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(FloodEmergencyStepsActivity.this,
                        IssueAlertsMenuActivity.class);
                startActivity(myIntent);
            }
        });
        emergencycontacts1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(FloodEmergencyStepsActivity.this,
                        EmergencyContactsActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
