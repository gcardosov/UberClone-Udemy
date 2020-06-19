package com.gcardoso.uberclone.activities.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gcardoso.uberclone.R;
import com.gcardoso.uberclone.activities.MainActivity;
import com.gcardoso.uberclone.providers.AuthProvider;

public class MapClientActivity extends AppCompatActivity {

    Button mButtonLogout;
    AuthProvider mAuthProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_client);

        mButtonLogout = findViewById(R.id.btnLogout);
        mAuthProvider = new AuthProvider();

        mButtonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mAuthProvider.logout();
                Intent intent = new Intent(MapClientActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
