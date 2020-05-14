package com.gcardoso.uberclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mButtonIAmClient;
    Button mButtonIAmDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonIAmClient = findViewById(R.id.btnIAmClient);
        mButtonIAmDriver = findViewById(R.id.btnIAmDriver);

        //Capturar el evento cuanto clickeamos el boton
        mButtonIAmClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectAuth();

            }
        });

        mButtonIAmDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSelectAuth();

            }
        });


    }


 //Ir de una actividad a otra
    private void goToSelectAuth() {
        Intent intent = new Intent(MainActivity.this, SelectOptionAuthActivity.class);
        startActivity(intent);
    }
}
