package com.example.prueba1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.app.*;
import android.os.Bundle;
import android.view.WindowManager;


import androidx.appcompat.app.AppCompatActivity;

public class splash_activity extends AppCompatActivity {

    private final int DURACION_SPASH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splash_activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DURACION_SPASH);

    }
}
