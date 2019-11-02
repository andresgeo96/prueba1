package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ingEjer15(View view){
        Intent i = new Intent(this,ejercicio15.class);
        startActivity(i);
    }

    public void ingEjer26(View view){
        Intent i = new Intent(this,ejercicio26.class);
        startActivity(i);
    }

    public void ingEjer39(View view){
        Intent i = new Intent(this,ejercicio39.class);
        startActivity(i);
    }

    public void ingEjer51(View view){
        Intent i = new Intent(this,ejercicio51.class);
        startActivity(i);
    }

}
