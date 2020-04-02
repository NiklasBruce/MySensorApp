package com.example.sensorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureCompassButton();
        configureAccButton();

    }
    private void configureAccButton(){
        Button accButton=(Button) findViewById(R.id.accButton);
        accButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,Accelerator.class));
            }

        });
    }
    private void configureCompassButton(){
        Button compassButton=(Button) findViewById(R.id.compassButton);
        compassButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this,Compass.class));
            }

        });
    }

}
