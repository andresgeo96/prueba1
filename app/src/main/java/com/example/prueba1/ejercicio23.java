package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class ejercicio23 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio23);
    }

    public void presionGato(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.gato);
        mp.start();
    }

    public void presionLeon(View view) {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.leon);
        mp.start();
    }

    public void salir(View view) {
        finish();
    }
}
