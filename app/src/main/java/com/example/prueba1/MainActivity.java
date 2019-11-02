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

    public void ingEjer14P1(View view){
        Intent i = new Intent(this,ejercicio14P1.class);
        startActivity(i);
    }

    public void ingEjer14P2(View view){
        Intent i = new Intent(this,ejercicio14P2.class);
        startActivity(i);
    }

    public void ingEjer15(View view){
        Intent i = new Intent(this,ejercicio15.class);
        startActivity(i);
    }

    public void ingEjer23(View view){
        Intent i = new Intent(this,ejercicio23.class);
        startActivity(i);
    }

    public void ingEjer26(View view){
        Intent i = new Intent(this,ejercicio26.class);
        startActivity(i);
    }

    public void ingEjer34(View view){
        Intent i = new Intent(this,ejercicio34.class);
        startActivity(i);
    }

    public void ingEjer39(View view){
        Intent i = new Intent(this,ejercicio39.class);
        startActivity(i);
    }

    public void ingEjer48(View view){
        Intent i = new Intent(this,ejercicio48.class);
        startActivity(i);
    }

    public void ingEjer51(View view){
        Intent i = new Intent(this,ejercicio51.class);
        startActivity(i);
    }

}
