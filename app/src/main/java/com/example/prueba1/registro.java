package com.example.prueba1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class registro extends AppCompatActivity {

    public EditText txtNombre;
    public EditText txtCorreo;
    public EditText txtPassword;
    public Button btnRegistrar;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mDatabase = FirebaseDatabase.getInstance().getReference();


        txtNombre = (EditText) findViewById(R.id.EdiNombre);
        txtCorreo = (EditText) findViewById(R.id.EdiCorreo);
        txtPassword = (EditText) findViewById(R.id.EdiPass);
        btnRegistrar = (Button) findViewById(R.id.btnResgitro);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarNuevosUsers();
            }
        });

    }


    private void agregarNuevosUsers() {
        String nombre = txtNombre.getText().toString();
        String correo = txtCorreo.getText().toString();
        String password = txtPassword.getText().toString();

        if(!nombre.isEmpty() && !correo.isEmpty()  && !password.isEmpty()){
            String id = mDatabase.push().getKey();
            User usuario= new User(id,nombre,correo,password);
            mDatabase.child("User").child(id).setValue(usuario);
            Toast t = Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT);
            t.show();
            Intent llamar = new Intent(this,MainActivity.class);
            startActivity(llamar);

        }else{
            Toast t = Toast.makeText(this, "No se pudo registrar usuario", Toast.LENGTH_SHORT);
            t.show();
        }
    }


}
