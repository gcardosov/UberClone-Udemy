package com.gcardoso.uberclone.providers;

import com.gcardoso.uberclone.models.Client;
import com.gcardoso.uberclone.models.Driver;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DriverProvider {
    DatabaseReference mDatabase;

    public DriverProvider(){
        //Haciendo referencia al nodo clientes
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Drivers");
    }

    public Task<Void> create(Driver driver){
        return mDatabase.child(driver.getId()).setValue(driver);
    }


}
