package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.VideoView;

import java.io.File;

public class ejercicio51 extends AppCompatActivity {

    private EditText et1;
    private VideoView vv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio51);

        et1=(EditText)findViewById(R.id.editText1);
        vv1=(VideoView)findViewById(R.id.videoview1);

        if (ContextCompat.checkSelfPermission(ejercicio51.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(ejercicio51.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(ejercicio51.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
    }

    private final int VIDEO_REQUEST_CODE = 100;


    public void tomarVideo(View v) {

        Intent intento1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video = new File(getExternalFilesDir(null), et1.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(video));
        startActivity(intento1);

        //File video = new File(getExternalFilesDir(null), et1.getText().toString());
        //Log.d("aaa", "tomarVideo: "+Uri.fromFile(video).toString());
        //intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(video));
        //startActivity(intento1);

        /*Intent intento1 = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video = new File(getExternalFilesDir(null), et1.getText().toString());
        intento1.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(video));
        startActivity(intento1);*/
    }




        /*
static final int REQUEST_VIDEO_CAPTURE = 1;

    public void tomarVideo(View view) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
     */

    public void recuperarVideo(View v) {
        vv1.setVideoURI(Uri.parse(getExternalFilesDir(null)+"/"+et1.getText().toString()));
        vv1.start();
    }


    public void ver(View v) {
        Intent intento1=new Intent(this,actividad2.class);
        startActivity(intento1);
    }
}
