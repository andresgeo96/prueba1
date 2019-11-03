package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText usuario;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (EditText)findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText4);
    }

    public void validar(View view) {
        try {

            String usu = usuario.getText().toString();
            String pass = password.getText().toString();

            if(usu.equals("admin")&&pass.equals("admin")){
            Intent i = new Intent(this,menu.class);
            i.putExtra("nombre",usuario.getText().toString());
            startActivity(i);

            }else{
                Toast t = Toast.makeText(this, "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT);
                t.show();
            }

        } catch (Exception e) {
            Toast t = Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT);
            t.show();
        }

    }


}
