package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {


    private EditText usuario;
    private EditText password;
    public static boolean entro = false;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        usuario = (EditText)findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText4);
    }

    public void validar(View view) {
        try {

            String usu = usuario.getText().toString();
            String pass = password.getText().toString();

            if(!usu.isEmpty() && !pass.isEmpty()){
                solicitarDatosFirebase(usu,pass);
            }else{
                Toast t = Toast.makeText(this, "LLENE TODOS LOS CAMPOS", Toast.LENGTH_SHORT);
                t.show();
            }

        } catch (Exception e) {
            Toast t = Toast.makeText(this, "ERROR ", Toast.LENGTH_SHORT);
            t.show();
        }

    }

    public void registro(View view){
        Intent i = new Intent(this,registro.class);
        startActivity(i);
    }

    public void solicitarDatosFirebase(final String usu, final String pass) {
        mDatabase.child("User").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(final DataSnapshot snapshot : dataSnapshot.getChildren()){
                    mDatabase.child("User").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            User user = snapshot.getValue(User.class);
                            String nombre = user.getUsername();
                            String correo = user.getEmail();
                            String clave = user.getPassword();

                            Log.e("NombreUsuario:",""+nombre);
                            Log.e("ApellidoUsuario:",""+correo);
                            Log.e("TelefonoUsuario:",""+clave);

                           if(correo.equals(usu) && clave.equals(pass)){
                               entro = true;
                               Intent llamar = new Intent(MainActivity.this,menu.class);
                               llamar.putExtra("nombre",correo);
                               startActivity(llamar);
                               finish();
                           }

                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        entro = false;
        if(entro == false){
            Toast t = Toast.makeText(MainActivity.this, "USURARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT);
            t.show();
        }
    }


}
