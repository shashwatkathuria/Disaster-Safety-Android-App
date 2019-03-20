package com.example.shash.earthquake4;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by shash on 24-10-2018.
 */

public class FetchData extends AsyncTask<Void,Void,Void>{

    public static int x,y,no=0;
    String data = "";
    String dataParsed = "";
    String singleParsed = "";
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (this.dataParsed!="") {
            GetCommonAlertsActivity.data.setText(this.dataParsed);

        }
        System.out.println(x);
        System.out.println(y);
    }

    @Override
    protected Void doInBackground(Void... voids) {
         x = no;
         y = no + 1 ;

        try {
            URL url = new URL("http://40.87.49.75/getcommonalerts");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";
            while(line != null)
            {
                line =  bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = null;
            try {
                JA = new JSONArray(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            no = JA.length();
            y = no;
            if (JA != null) {


                for(int i=0;i < JA.length();i++)
                {
                    JSONObject JO = null;
                    try {
                        JO = (JSONObject) JA.get(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        singleParsed ="________________________" + "\n" + "Date And Time : " + JO.get("datetime") + " GMT "+ "\n" +
                                "Calamity      : " + JO.get("calamity") + "\n" +
                                "Location      : " + JO.get("location") + "\n" +
                                "Description   : " + JO.get("description") + "\n";
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    dataParsed = dataParsed + singleParsed ;

                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
