package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Reproductor extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;
    int repetir = 2;
    int posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView);

        vectormp[0] = MediaPlayer.create(this, R.raw.pasos_aldeanos);
        vectormp[1] = MediaPlayer.create(this, R.raw.belove_teddy);
        vectormp[2] = MediaPlayer.create(this, R.raw.luna_cadillacs);
    }

    public void PlayPause(View view){
        if (vectormp[posicion].isPlaying()){

            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir1);
            Toast.makeText(this, "PAUSA", Toast.LENGTH_SHORT).show();

        }else{

            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "PLAY", Toast.LENGTH_SHORT).show();

        }
    }

    public void Stop(View view){
        if (vectormp[posicion] != null){

            vectormp[posicion].stop();
            vectormp[0] = MediaPlayer.create(this, R.raw.pasos_aldeanos);
            vectormp[1] = MediaPlayer.create(this, R.raw.belove_teddy);
            vectormp[2] = MediaPlayer.create(this, R.raw.luna_cadillacs);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir1);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show();

        }
    }

    public void repetir(View view){
        if (repetir == 1){

            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this, "NO REPETIR", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);
            repetir = 2;

        }else{

            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this, "REPETIR", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);
            repetir = 1;

        }
    }

    public void siguiente(View view){
        if (posicion < vectormp.length -1){

            if (vectormp[posicion].isPlaying()){

                vectormp[posicion].stop();
                posicion++;

                if (posicion==0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.portada3);
                }

                vectormp[posicion].start();

            }else{

                posicion++;
                if (posicion==0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }

        }else{

            Toast.makeText(this, "NO HAY MAS CANCIONES", Toast.LENGTH_SHORT).show();

        }
    }

    public void retroceder(View view){
        if (posicion >= 1){

            if (vectormp[posicion].isPlaying()){

                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.pasos_aldeanos);
                vectormp[1] = MediaPlayer.create(this, R.raw.belove_teddy);
                vectormp[2] = MediaPlayer.create(this, R.raw.luna_cadillacs);

                posicion--;

                if (posicion==0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.portada3);
                }

                vectormp[posicion].start();

            }else{

                posicion--;

                if (posicion==0){
                    iv.setImageResource(R.drawable.portada1);
                }else if (posicion==1){
                    iv.setImageResource(R.drawable.portada2);
                }else if (posicion==2){
                    iv.setImageResource(R.drawable.portada3);
                }
            }

        }else{

            Toast.makeText(this, "NO HAY MAS CANCIONES", Toast.LENGTH_SHORT).show();

        }
    }
}
