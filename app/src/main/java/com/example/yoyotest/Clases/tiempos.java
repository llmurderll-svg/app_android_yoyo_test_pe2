package com.example.yoyotest.Clases;

import java.io.Serializable;

public class tiempos implements Serializable {


    private String tiempo;
    private String velocidad;
    public tiempos(String tiempo, String velocidad)
    {
        this.tiempo = tiempo;
        this.velocidad = velocidad;
    }
    public String getTiempo(){return this.tiempo;}
    public String getVelocidad(){return this.velocidad;}
}
