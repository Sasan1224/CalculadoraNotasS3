package com.example.s3notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


public class CalculoActivity extends AppCompatActivity {
    private EditText editProject1;
    private EditText editProject2;
    private EditText editQuices;
    private EditText editFinalExam1;
    private EditText editFinalExam2;
    private Button bCalcular;
    private EditText editSemanal;
    private ConstraintLayout fondocal;
    private String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);


        editProject1 = findViewById(R.id.editProject1);
        editProject2 = findViewById(R.id.editProject2);
        editQuices = findViewById(R.id.editQuices);
        editFinalExam1 = findViewById(R.id.editFinalExam1);
        editFinalExam2 = findViewById(R.id.editFinalExam2);
        bCalcular = findViewById(R.id.bCalcular);
        editSemanal = findViewById(R.id.editSemanal);
        fondocal = findViewById(R.id.fondocal);

        SharedPreferences preferencias = getSharedPreferences("buzonColor",MODE_PRIVATE);
        color = preferencias.getString("colorin","nocolorin");
        if (color.equals("Verde")) {
            fondocal.setBackgroundColor(Color.rgb(0, 200, 0));
        }
        if (color.equals("Blanco")) {
            fondocal.setBackgroundColor(Color.rgb(200, 200, 200));
        }
        if(color.equals("Rojo")) {
            fondocal.setBackgroundColor(Color.rgb(200,0,0));

        }

        String nombre = getIntent().getExtras().getString("nombre");

        // editProyecto1.setText(nombre);

         bCalcular.setOnClickListener(


                 (v)->{
                    String proyecto1 = editProject1.getText().toString();
                     String proyecto2 = editProject2.getText().toString();
                     String quizz = editQuices.getText().toString();
                     String parcial1 = editFinalExam1.getText().toString();
                     String parcial2 = editFinalExam2.getText().toString();
                     String semanal = editSemanal.getText().toString();



                     double pro1 = Double.parseDouble(proyecto1);
                     double pro2 = Double.parseDouble(proyecto2);
                     double quiz = Double.parseDouble(quizz);
                     double par1 = Double.parseDouble(parcial1);
                     double par2 = Double.parseDouble(parcial2);
                     double sem = Double.parseDouble(semanal);

                     double cali = (pro1*0.25)+(pro2*0.25)+(quiz*0.15)+(par1*0.15)+(par2*0.15)+(sem*0.05);
                     Intent y = new Intent(this,ResultadoActivity.class);
                     y.putExtra("notas",cali);
                     startActivity(y);

                     Log.d("calculo","" + cali);
                     Log.d("notas","" + pro1 );





                     y.putExtra("nombre",nombre);

                     startActivity(y);

                 }
         );

    }
    }