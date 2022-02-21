package com.example.calculadora.modelo;

import androidx.appcompat.app.AppCompatActivity;

public class materia implements Comparable<materia>{
    String nombre;
    double primer, segundo ,tercer, filtrar;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrimer() {
        return primer;
    }

    public void setPrimer(double primer) {
        this.primer = primer;
    }

    public double getSegundo() {
        return segundo;
    }

    public void setSegundo(double segundo) {
        this.segundo = segundo;
    }

    public double getTercer() {
        return tercer;
    }

    public void setTercer(double tercer) {
        this.tercer = tercer;
    }

    public double getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(double filtrar) {
        this.filtrar = filtrar;
    }

    @Override
    public int compareTo(materia m) {
        if (filtrar < m.filtrar) {
            return -1;
        }
        if (filtrar > m.filtrar) {
            return 1;
        }
        return 0;
    }

    public String tostring(){
        return nombre +"-"+primer+"-"+segundo+"-"+ tercer;
    }

    public materia(String nombre, double primer, double segundo, double tercer) {
        this.nombre = nombre;
        this.primer = primer;
        this.segundo = segundo;
        this.tercer = tercer;
    }

    public materia() {
    }

    public void convertir(String ob){
        String[] fil = ob.split("-");
        this.nombre = fil[0];
        this.primer = Double.valueOf(fil[1]);
        this.segundo = Double.valueOf(fil[2]);
        this.tercer = Double.valueOf(fil[3]);
    }


}
