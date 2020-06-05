package com.gcardoso.uberclone.includes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.gcardoso.uberclone.R;

public class MyToolbar {

    public static void show(AppCompatActivity activity, String title, boolean upButton){

        Toolbar mToolbar = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
