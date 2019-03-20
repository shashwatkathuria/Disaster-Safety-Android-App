package com.example.shash.earthquake4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

public class EmergencyContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);

        QuickContactBadge ambulance = (QuickContactBadge) findViewById(R.id.Ambulance);
        ambulance.assignContactFromPhone("102", true);
        QuickContactBadge police = (QuickContactBadge) findViewById(R.id.Police);
        police.assignContactFromPhone("100", true);
        QuickContactBadge disastermanagement = (QuickContactBadge) findViewById(R.id.DisasterManagement);
        disastermanagement.assignContactFromPhone("108", true);
        QuickContactBadge fire = (QuickContactBadge) findViewById(R.id.Fire);
        fire.assignContactFromPhone("101", true);
    }
}
