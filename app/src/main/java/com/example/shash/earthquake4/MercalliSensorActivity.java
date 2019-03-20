package com.example.shash.earthquake4;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import java.util.Arrays;

public class MercalliSensorActivity extends AppCompatActivity implements SensorEventListener{
    private NotificationManager mNotificationManager;

    private TextView xView,XII,XI,X,IX,VIII,VII,VI,V,IV,III,II,I;
    private Sensor mySensor;
    private SensorManager SM;
    private double[] accns = new double[20];
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercalli_sensor);

        SM = (SensorManager)getSystemService(SENSOR_SERVICE);


        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SM.registerListener(this,mySensor,SensorManager.SENSOR_STATUS_ACCURACY_HIGH);


        xView = (TextView)findViewById(R.id.xView);
        XII = (TextView)findViewById(R.id.XII);
        XI = (TextView)findViewById(R.id.XI);
        X = (TextView)findViewById(R.id.X);
        IX = (TextView)findViewById(R.id.IX);
        VIII = (TextView)findViewById(R.id.VIII);
        VII = (TextView)findViewById(R.id.VII);
        VI = (TextView)findViewById(R.id.VI);
        V = (TextView)findViewById(R.id.V);
        IV = (TextView)findViewById(R.id.IV);
        III = (TextView)findViewById(R.id.III);
        II = (TextView)findViewById(R.id.II);
        I = (TextView)findViewById(R.id.I);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent event) {
        double accnx = Math.pow((double)(event.values[0]),2);
        double accny = Math.pow((double)(event.values[1]),2);
        double accnz = Math.pow((double)(event.values[2]),2);
        double accn  = Math.pow((double)(accnx + accny + accnz),0.5);
        double totalaccn = Math.abs(accn-9.81);
        double avg = 0.0;
        for(int j=0; j<20;j++)
        {
            avg+= accns[j];
        }
        avg/=20;
        xView.setText("INSTANTANEOUS: " + String.format( "%.2f", totalaccn ) + " m" + "²" + "/s " + "\n" + "AVERAGE: " + String.format( "%.2f", avg ) + " m" + "²" + "/s");
        // yView.setText( Double.toString(avg) );
        // zView.setText("Z: " + Integer.toString(i));
        accns[i] = totalaccn;
        i++;
        if(i == 20)
        {
            i = 0;
        }
        XII.setTextColor(0xff000000);
        XI.setTextColor(0xff000000);
        X.setTextColor(0xff000000);
        IX.setTextColor(0xff000000);
        VIII.setTextColor(0xff000000);
        VII.setTextColor(0xff000000);
        VI.setTextColor(0xff000000);
        V.setTextColor(0xff000000);
        IV.setTextColor(0xff000000);
        III.setTextColor(0xff000000);
        II.setTextColor(0xff000000);
        I.setTextColor(0xff000000);

        XII.setTypeface(null, Typeface.NORMAL);
        XI.setTypeface(null, Typeface.NORMAL);
        X.setTypeface(null, Typeface.NORMAL);
        IX.setTypeface(null, Typeface.NORMAL);
        VIII.setTypeface(null, Typeface.NORMAL);
        VII.setTypeface(null, Typeface.NORMAL);
        VI.setTypeface(null, Typeface.NORMAL);
        V.setTypeface(null, Typeface.NORMAL);
        IV.setTypeface(null, Typeface.NORMAL);
        III.setTypeface(null, Typeface.NORMAL);
        II.setTypeface(null, Typeface.NORMAL);
        I.setTypeface(null, Typeface.NORMAL);





        if(avg >= 4.0)
        {
            XII.setTypeface(null, Typeface.BOLD);
            XII.setTextColor(0xffff0000);
        }
        else if (avg >= 3.5 )
        {
            XI.setTypeface(null, Typeface.BOLD);
            XI.setTextColor(0xffff0000);
        }
        else if (avg >= 3.0)
        {
            X.setTypeface(null, Typeface.BOLD);
            X.setTextColor(0xffff0000);
        }
        else if (avg >= 2.5)
        {
            IX.setTypeface(null, Typeface.BOLD);
            IX.setTextColor(0xffff0000);
        }
        else if (avg >= 2.0)
        {
            VIII.setTypeface(null, Typeface.BOLD);
            VIII.setTextColor(0xffff0000);
        }
        else if (avg >= 1.5)
        {
            VII.setTypeface(null, Typeface.BOLD);
            VII.setTextColor(0xffff0000);
        }
        else if (avg >= 1.0)
        {
            VI.setTypeface(null, Typeface.BOLD);
            VI.setTextColor(0xffff0000);
        }
        else if (avg >= 0.8)
        {
            V.setTypeface(null, Typeface.BOLD);
            V.setTextColor(0xffff0000);
        }
        else if (avg >= 0.45)
        {
            IV.setTypeface(null, Typeface.BOLD);
            IV.setTextColor(0xffff0000);
        }
        else if (avg >= 0.3)
        {
            III.setTypeface(null, Typeface.BOLD);
            III.setTextColor(0xff00ff00);
        }
        else if (avg >= 0.2)
        {
            II.setTypeface(null, Typeface.BOLD);
            II.setTextColor(0xff00ff00);
        }
        else if (avg >= 0.0)
        {
            I.setTypeface(null, Typeface.BOLD);
            I.setTextColor(0xff00ff00);
        }
        if(avg >= 0.45 )
        {


            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this.getApplicationContext(), "notify_001");
            Intent ii = new Intent(this.getApplicationContext(), EarthquakeEmergencyStepsActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, ii, 0);

            NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
            bigText.bigText("Follow emergency steps!!");
            bigText.setBigContentTitle("EARTHQUAKE ALERT!!");
            bigText.setSummaryText("ABNORMAL VIRATIONS SENSED!!");

            mBuilder.setContentIntent(pendingIntent);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
            mBuilder.setContentTitle("Earthquake Alert!!");
            mBuilder.setContentText("Abnormal Vibrations Sensed!!");
            mBuilder.setPriority(Notification.PRIORITY_MAX);
            mBuilder.setStyle(bigText);

            mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("notify_001",
                        "Channel human readable title",
                        NotificationManager.IMPORTANCE_DEFAULT);
                mNotificationManager.createNotificationChannel(channel);
            }

            mNotificationManager.notify(0, mBuilder.build());
        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Not in use
    }
}
