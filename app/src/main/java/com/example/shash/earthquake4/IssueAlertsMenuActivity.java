package com.example.shash.earthquake4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IssueAlertsMenuActivity extends AppCompatActivity {
    Button issuecommon,issuegovt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_alerts_menu);

        issuecommon = (Button)findViewById(R.id.issuecommon);
        issuegovt = (Button)findViewById(R.id.issuegovt);

        issuecommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(IssueAlertsMenuActivity.this,
                        IssueCommonAlertsActivity.class);
                startActivity(myIntent);
            }
        });
        issuegovt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(IssueAlertsMenuActivity.this,
                        IssueGovtAlertsActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
