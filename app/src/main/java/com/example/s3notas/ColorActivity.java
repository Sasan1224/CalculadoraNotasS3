package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity {
    private Button bVerde;
    private Button bBlanco;
    private Button bRojo;
    private String colores;
    private ConstraintLayout fondoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //Referenciar
        bVerde = findViewById(R.id.bVerde);
        bBlanco = findViewById(R.id.bBlanco);
        bRojo = findViewById(R.id.bRojo);
        fondoc = findViewById(R.id.fondoc);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
colores = preferencias.getString("colorin","nocolorin");
        if (colores.equals("Verde")) {
            fondoc.setBackgroundColor(Color.rgb(0, 200, 0));
        }
        if (colores.equals("Blanco")) {
            fondoc.setBackgroundColor(Color.rgb(200, 200, 200));
        }
        if(colores.equals("Rojo")) {
            fondoc.setBackgroundColor(Color.rgb(200,0,0));

        }

        bVerde.setOnClickListener(
                (view)-> {
                    Intent i = new Intent();
                    i.putExtra("color","Verde");
                    setResult(RESULT_OK,i);
                    finish();

                }
        );
        bBlanco.setOnClickListener(
                (view)->{
                    Intent o = new Intent();
                    o.putExtra("color","Blanco");
                    setResult(RESULT_OK,o);
                    finish();

                }
        );
        bRojo.setOnClickListener(
                (view)->{
                    Intent p = new Intent();
                        p.putExtra("color","Rojo");
                    setResult(RESULT_OK,p);
                    finish();


                }

        );
    }
}