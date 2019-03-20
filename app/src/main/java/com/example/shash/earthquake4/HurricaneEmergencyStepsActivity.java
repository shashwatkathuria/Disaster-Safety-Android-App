package com.example.shash.earthquake4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HurricaneEmergencyStepsActivity extends AppCompatActivity {
    Button issuealert2,emergencycontacts2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hurricane_emergency_steps);
        issuealert2 = (Button)findViewById(R.id.issuealertbutton2);
        emergencycontacts2 = (Button) findViewById(R.id.emergencycontactsbutton2);
        issuealert2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(HurricaneEmergencyStepsActivity.this,
                        IssueAlertsMenuActivity.class);
                startActivity(myIntent);
            }
        });
        emergencycontacts2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent myIntent = new Intent(HurricaneEmergencyStepsActivity.this,
                        EmergencyContactsActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
