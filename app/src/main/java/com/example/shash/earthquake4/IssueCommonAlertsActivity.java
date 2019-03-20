package com.example.shash.earthquake4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class IssueCommonAlertsActivity extends AppCompatActivity {
    TextView textt;
    Button sendbutton;
    EditText calamity, location, description;
    String URL_POST = "http://40.87.49.75/commonalerts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_common_alerts);

        sendbutton = (Button) findViewById(R.id.issuealertsubmitbutton);
        calamity = (EditText) findViewById(R.id.calamityinput);
        location = (EditText) findViewById(R.id.locationinput);
        description = (EditText) findViewById(R.id.descriptioninput);
        textt = (TextView) findViewById(R.id.textt);


        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                InsertSV();
            }
        });

    }

    private void InsertSV() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_POST, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplication(), response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(IssueCommonAlertsActivity.this, error + "", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();

                String loc = location.getText().toString();
                String cal = calamity.getText().toString();
                String desc = description.getText().toString();
                params.put("location", loc);
                params.put("calamity", cal);
                params.put("description", desc);

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}