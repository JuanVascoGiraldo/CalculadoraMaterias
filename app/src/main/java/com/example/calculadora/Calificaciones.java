package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.EventStats;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculadora.modelo.materia;

import java.util.ArrayList;

public class Calificaciones extends AppCompatActivity {

    int i = 0;
    EditText calpri, calseg, calter;
    Button sig, ant;
    TextView materia;
    ArrayList<materia> materias = new ArrayList<materia>();
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calificaciones);
        calpri = findViewById(R.id.calpri);
        calseg = findViewById(R.id.calseg);
        calter = findViewById(R.id.calter);
        sig = findViewById(R.id.sigui);
        ant = findViewById(R.id.ant);
        materia = findViewById(R.id.materia);

        usuario = getIntent().getStringExtra("nombre");

        materia ma1 = new materia("Probabilidad y Estadística", 0,0,0);
        materia ma2 = new materia("Física IV", 0,0,0);
        materia ma3 = new materia("Química IV", 0,0,0);
        materia ma4 = new materia("Inglés VI", 0,0,0);
        materia ma5 = new materia("Orientación Juvenil y Profesional IV", 0,0,0);
        materia ma6 = new materia("Métodos Ágiles de Programación", 0,0,0);
        materia ma7 = new materia("Soporte de Software", 0,0,0);
        materia ma8 = new materia("Ingeniería de Software Básica", 0,0,0);
        materia ma9 = new materia("Laboratorio de Proyectos de Tecnologías de la Información IV", 0,0,0);
        materia ma10 = new materia("Proyecto Integrador", 0,0,0);
        materias.add(ma1);
        materias.add(ma2);
        materias.add(ma3);
        materias.add(ma4);
        materias.add(ma5);
        materias.add(ma6);
        materias.add(ma7);
        materias.add(ma8);
        materias.add(ma9);
        materias.add(ma10);

        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sig();
            }
        });

        ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ant();
            }
        });

        enviar();
    }

    public void enviar(){
        materia.setText(materias.get(i).getNombre());
        calpri.setText(String.valueOf(materias.get(i).getPrimer()));
        calseg.setText(String.valueOf(materias.get(i).getSegundo()));
        calter.setText(String.valueOf(materias.get(i).getTercer()));
    }

    public void sig(){
        String nombre = String.valueOf(materia.getText());
        double cpri = Double.valueOf(String.valueOf(calpri.getText()));
        double cseg = Double.valueOf(String.valueOf(calseg.getText()));
        double cter = Double.valueOf(String.valueOf(calter.getText()));
        boolean se = true;
        if(cpri<0 || cpri > 10){
            se = false;
        }else if(cseg<0 || cseg>10){
            se = false;
        }else if(cter<0 || cter>10){
            se = false;
        }

        if(se){
            materias.remove(i);
            materia ma = new materia();
            ma.setNombre(nombre);
            ma.setPrimer(cpri);
            ma.setSegundo(cseg);
            ma.setTercer(cter);
            materias.add(i, ma);
            if( i < materias.size()-1 ){
                i++;
                enviar();
                if(9 == i){
                    sig.setText("Terminar");
                }
            }else if(9 == i){
                estadisticas();
            }
        }else{
            Toast.makeText(this, "Algunas Calificaciones son invalidas",Toast.LENGTH_SHORT).show();
        }
    }

    public void ant(){
        String nombre = String.valueOf(materia.getText());
        double cpri = Double.valueOf(String.valueOf(calpri.getText()));
        double cseg = Double.valueOf(String.valueOf(calseg.getText()));
        double cter = Double.valueOf(String.valueOf(calter.getText()));
        boolean se = true;
        if(cpri<0 || cpri > 10){
            se = false;
        }else if(cseg<0 || cseg>10){
            se = false;
        }else if(cter<0 || cter>10){
            se = false;
        }

        if(se){
            materias.remove(i);
            materia ma = new materia();
            ma.setNombre(nombre);
            ma.setPrimer(cpri);
            ma.setSegundo(cseg);
            ma.setTercer(cter);
            materias.add(i, ma);
            if(i > 0){
                i--;
                enviar();
            }
        }else{
            Toast.makeText(this, "Algunas Calificaciones son invalidas",Toast.LENGTH_SHORT).show();
        }
    }


    public void estadisticas(){
        ArrayList<String> mats = new ArrayList<String>();
        for(materia mm: materias){
            mats.add(mm.tostring());
        }
        Intent i = new Intent(this, Estadisticas.class);
        i.putExtra("nombre", usuario);
        i.putStringArrayListExtra("materias", mats);
        startActivity(i);
    }
}