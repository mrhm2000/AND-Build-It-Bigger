package com.project.andjokeslib;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


/**
 * Created on july 2018
 */

public class ActJokes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lotjokesact);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container,new ActJokesFrag()).commit();
        }
    }
}
