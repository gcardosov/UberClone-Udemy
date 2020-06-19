package com.gcardoso.uberclone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gcardoso.uberclone.R;
import com.gcardoso.uberclone.activities.client.MapClientActivity;
import com.gcardoso.uberclone.activities.driver.MapDriverActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button mButtonIAmClient;
    Button mButtonIAmDriver;
    SharedPreferences mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPref = getApplicationContext().getSharedPreferences("typeUser", MODE_PRIVATE);
        final SharedPreferences.Editor editor = mPref.edit();


        mButtonIAmClient = findViewById(R.id.btnIAmClient);
        mButtonIAmDriver = findViewById(R.id.btnIAmDriver);

        //Capturar el evento cuanto clickeamos el boton
        mButtonIAmClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("user", "client");
                editor.apply();
                goToSelectAuth();

            }
        });

        mButtonIAmDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("user", "driver");
                editor.apply();
                goToSelectAuth();

            }
        });
    }

    //Esta seccion sobre escribiendo el metodo onStart en esta actividad dejamos abierta la sesion de los usuarios
    //ya que en firebase se abre la sesión
    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            String user = mPref.getString("user", "");
            if (user.equals("client")){
                Intent intent = new Intent(MainActivity.this, MapClientActivity.class);
                //Con las propiedades de flags no vamos a poder regresar al activity anterior
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }else{
                Intent intent = new Intent(MainActivity.this, MapDriverActivity.class);
                //Con las propiedades de flags no vamos a poder regresar al activity anterior
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        }
    }

    //Ir de una actividad a otra
    private void goToSelectAuth() {
        Intent intent = new Intent(MainActivity.this, SelectOptionAuthActivity.class);
        startActivity(intent);
    }
}
