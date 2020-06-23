package com.gcardoso.uberclone.activities.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gcardoso.uberclone.R;
import com.gcardoso.uberclone.activities.MainActivity;
import com.gcardoso.uberclone.activities.client.MapClientActivity;
import com.gcardoso.uberclone.includes.MyToolbar;
import com.gcardoso.uberclone.providers.AuthProvider;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
//Para implementar la interface OnMapReadyCallback nos marca errores por lo cual necesitamos
//sobreesribir algunos metodos

public class MapDriverActivity extends AppCompatActivity implements OnMapReadyCallback {

    //Declaramos lo que vamos a ocupar con el mapa
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    private AuthProvider mAuthProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_driver);
        //Vamos a mostrar el toobar
        MyToolbar.show(this, "Conductor", false);
        //Instanciamos la variables
        //Nos marco error al acceder al metodo getSupportFragmentManager asi que tuvimos que castear
        //al tipo SupportMapFragment
        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //el metodo recibe una actividad como parametro
        mMapFragment.getMapAsync(this);
        mAuthProvider = new AuthProvider();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.driver_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    void logout(){
        mAuthProvider.logout();
        Intent intent = new Intent(MapDriverActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
