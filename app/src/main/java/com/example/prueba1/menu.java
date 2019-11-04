package com.example.prueba1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private ListView lv1;

    public String nombres [] = {"EJERCICIO 14 PARTE 1", "EJERCICIO 14 PARTE 2", "EJERCICIO 15", "EJERCICIO 23",
            "EJERCICIO 26", "EJERCICIO 39", "EJERCICIO 48", "EJERCICIO 51"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.usu);
        lv1 = (ListView)findViewById(R.id.lv1);

        Bundle bundle = getIntent().getExtras();
        tv2.setText(bundle.getString("nombre"));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_geekipedia, nombres);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(lv1.getItemIdAtPosition(position)==0){
                    LlamarEjer41_1();
                }else if(lv1.getItemIdAtPosition(position)==1){
                    LlamarEjer41_2();
                }else if(lv1.getItemIdAtPosition(position)==2){
                    LlamarEjer15();
                }else if(lv1.getItemIdAtPosition(position)==3){
                    LlamarEjer23();
                }else if(lv1.getItemIdAtPosition(position)==4){
                    LlamarEjer26();
                }else if(lv1.getItemIdAtPosition(position)==5){
                    LlamarEjer34();
                }else if(lv1.getItemIdAtPosition(position)==6){
                    LlamarEjer48();
                }else if(lv1.getItemIdAtPosition(position)==7){
                    LlamarEjer51();
                }else{

                }
            }
        });

    }

    public void LlamarEjer41_1(){
        Intent llamar = new Intent(this,ejercicio14P1.class);
        startActivity(llamar);
    }
    public void LlamarEjer41_2(){
        Intent llamar = new Intent(this,ejercicio14P2.class);
        startActivity(llamar);
    }
    public void LlamarEjer15(){
        Intent llamar = new Intent(this,ejercicio15.class);
        startActivity(llamar);
    }
    public void LlamarEjer23(){
        Intent llamar = new Intent(this,ejercicio23.class);
        startActivity(llamar);
    }
    public void LlamarEjer26(){
        Intent llamar = new Intent(this,ejercicio26.class);
        startActivity(llamar);
    }
    public void LlamarEjer34(){
        Intent llamar = new Intent(this,ejercicio34.class);
        startActivity(llamar);
    }
    public void LlamarEjer39(){
        Intent llamar = new Intent(this,ejercicio39.class);
        startActivity(llamar);
    }
    public void LlamarEjer48(){
        Intent llamar = new Intent(this,ejercicio48.class);
        startActivity(llamar);
    }
    public void LlamarEjer51(){
        Intent llamar = new Intent(this,ejercicio51.class);
        startActivity(llamar);
    }

    public void LlamarReproductor(View view){
        Intent llamar = new Intent(this,Reproductor.class);
        startActivity(llamar);
    }
}
