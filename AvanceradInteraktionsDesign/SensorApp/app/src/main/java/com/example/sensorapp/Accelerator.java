package com.example.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Accelerator extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";
    TextView X;
    TextView Y;
    TextView Z;
    TextView orientation;
    private SensorManager sensorManager;
    Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerator);
        X = (TextView) findViewById(R.id.accX);
        Y = (TextView) findViewById(R.id.accY);
        Z = (TextView) findViewById(R.id.accZ);
        orientation=(TextView) findViewById(R.id.orientation);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Accelerator.this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "OnSensorChanged: X: " + event.values[0] + " Y: " + event.values[1] + " Z: " + event.values[2]);

    X.setText("X: " + event.values[0]);

    Y.setText("Y: "+event.values[1]);
    Z.setText("Z: "+ event.values[2]);

    if(event.values[0]>0) {
        orientation.setText("Left");

    }

    if(event.values[1]<0) {
            orientation.setText("Right");


        }

    }


        @Override
        public void onAccuracyChanged (Sensor sensor,int accuracy){

        }

}