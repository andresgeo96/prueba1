package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class ejercicio34 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio34);

        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        Lienzo fondo = new Lienzo(this);
        layout1.addView(fondo);
        getSupportActionBar().hide();
    }
}
class Lienzo extends View {

    public Lienzo(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        canvas.drawRGB(255, 255, 255);
        int ancho = canvas.getWidth();
        int alto = canvas.getHeight();

        Paint pincel1 = new Paint();
        pincel1.setARGB(255, 0, 0, 0);
        pincel1.setStrokeWidth(5);
        pincel1.setStyle(Paint.Style.STROKE);
        RectF rectangulo1 = new RectF(0, 0, ancho, alto);
        canvas.drawOval(rectangulo1, pincel1);

        int menor;
        if (ancho < alto)
            menor = ancho;
        else
            menor = alto;

        pincel1.setStyle(Paint.Style.FILL);
        pincel1.setARGB(255, 255, 255, 0);
        canvas.drawCircle(ancho / 2, alto / 2, menor / 2, pincel1);
    }
}




