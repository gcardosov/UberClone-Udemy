package com.gcardoso.uberclone.activities.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gcardoso.uberclone.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
//Para implementar la interface OnMapReadyCallback nos marca errores por lo cual necesitamos
//sobreesribir algunos metodos

public class MapDriverActivity extends AppCompatActivity implements OnMapReadyCallback {

    //Declaramos lo que vamos a ocupar con el mapa
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_driver);
        //Instanciamos la variables
        //Nos marco error al acceder al metodo getSupportFragmentManager asi que tuvimos que castear
        //al tipo SupportMapFragment
        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        //el metodo recibe una actividad como parametro
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
