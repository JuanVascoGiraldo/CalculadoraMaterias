package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculadora.modelo.materia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Estadisticas extends AppCompatActivity {

    Button bprimero, bsegundo, btercero, bsemestre;
    TextView bienvenida, parcial, promedio, malta,mbaja, repro;
    ArrayList<materia> materias = new  ArrayList<materia>();
    String nombre = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        bprimero = findViewById(R.id.bprimer);
        bsegundo  = findViewById(R.id.bsegundo);
        btercero = findViewById(R.id.btercero);
        bsemestre = findViewById(R.id.bsemestre);
        bienvenida = findViewById(R.id.bienvenida);
        parcial = findViewById(R.id.parcial);
        promedio = findViewById(R.id.promedio);
        malta = findViewById(R.id.malta);
        mbaja = findViewById(R.id.mbaja);
        repro = findViewById(R.id.repro);

        nombre = getIntent().getStringExtra("nombre");
        ArrayList<String> ms = getIntent().getStringArrayListExtra("materias");

        for(String mas: ms){
            materia ma = new materia();
            ma.convertir(mas);
            materias.add(ma);
        }
        bienvenida.setText(nombre + " tus estadisticas son");

        primer();

        bprimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                primer();
            }
        });

        bsegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segundo();
            }
        });

        btercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tercer();
            }
        });

        bsemestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                semestre();
            }
        });


    }

    public void primer(){
        parcial.setText("Primer Parcial");
        double promedios = 0;
        String reprobadas = "";
        int i = 0;
        for(materia ma: materias){
            ma.setFiltrar(ma.getPrimer());
            if(ma.getPrimer() < 6){
                i++;
                reprobadas += ma.getNombre() + ", ";
            }
            promedios += ma.getPrimer();
        }
        promedios /= 10;
        Collections.sort(materias, new Comparator<materia>() {
            @Override
            public int compare(materia m1, materia m2) {
                return new Integer((int) m2.getFiltrar()).compareTo((int)m1.getFiltrar()) ;
            }
        });

        promedio.setText(String.valueOf(promedios));
        malta.setText(materias.get(0).getNombre() +": " +String.valueOf(materias.get(0).getFiltrar()));
        mbaja.setText(materias.get(9).getNombre() +": " +String.valueOf(materias.get(9).getFiltrar()));
        if(i > 0){
            repro.setText(reprobadas);
        }else{
            repro.setText("no hay materias reprobadas");
        }
    }

    public void segundo(){
        parcial.setText("Segundo Parcial");
        double promedios = 0;
        String reprobadas = "";
        int i = 0;
        for(materia ma: materias){
            ma.setFiltrar(ma.getSegundo());
            if(ma.getSegundo() < 6){
                i++;
                reprobadas += ma.getNombre() + ", ";
            }
            promedios += ma.getSegundo();
        }
        promedios /= 10;
        Collections.sort(materias, new Comparator<materia>() {
            @Override
            public int compare(materia m1, materia m2) {
                return new Integer((int) m2.getFiltrar()).compareTo((int)m1.getFiltrar()) ;
            }
        });

        promedio.setText(String.valueOf(promedios));
        malta.setText(materias.get(0).getNombre() +": " +String.valueOf(materias.get(0).getFiltrar()));
        mbaja.setText(materias.get(9).getNombre() +": " +String.valueOf(materias.get(9).getFiltrar()));
        if(i > 0){
            repro.setText(reprobadas);
        }else{
            repro.setText("no hay materias reprobadas");
        }
    }

    public void tercer(){
        parcial.setText("Tercer Parcial");
        double promedios = 0;
        String reprobadas = "";
        int i = 0;
        for(materia ma: materias){
            ma.setFiltrar(ma.getTercer());
            if(ma.getTercer() < 6){
                i++;
                reprobadas += ma.getNombre() + ", ";
            }
            promedios += ma.getTercer();
        }
        promedios /= 10;
        Collections.sort(materias, new Comparator<materia>() {
            @Override
            public int compare(materia m1, materia m2) {
                return new Integer((int) m2.getFiltrar()).compareTo((int)m1.getFiltrar()) ;
            }
        });

        promedio.setText(String.valueOf(promedios));
        malta.setText(materias.get(0).getNombre() +": " +String.valueOf(materias.get(0).getFiltrar()));
        mbaja.setText(materias.get(9).getNombre() +": " +String.valueOf(materias.get(9).getFiltrar()));
        if(i > 0){
            repro.setText(reprobadas);
        }else{
            repro.setText("no hay materias reprobadas");
        }
    }

    private void semestre(){
        parcial.setText("Semestre");
        double promedios = 0;
        String reprobadas = "";
        int i = 0;
        for(materia ma: materias){
            double total = ma.getPrimer() + ma.getSegundo() + ma.getTercer();
            total /= 3;
            ma.setFiltrar(total);
            if(total < 6){
                i++;
                reprobadas += ma.getNombre() + ", ";
            }
            promedios += total;
        }
        promedios /= 10;
        Collections.sort(materias, new Comparator<materia>() {
            @Override
            public int compare(materia m1, materia m2) {
                return new Integer((int) m2.getFiltrar()).compareTo((int)m1.getFiltrar()) ;
            }
        });

        promedio.setText(String.valueOf(promedios));
        malta.setText(materias.get(0).getNombre() +": " +String.valueOf(materias.get(0).getFiltrar()));
        mbaja.setText(materias.get(9).getNombre() +": " +String.valueOf(materias.get(9).getFiltrar()));
        if(i > 0){
            repro.setText(reprobadas);
        }else{
            repro.setText("no hay materias reprobadas");
        }
    }
}