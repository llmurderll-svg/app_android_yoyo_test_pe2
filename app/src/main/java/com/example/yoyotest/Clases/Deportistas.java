package com.example.yoyotest.Clases;

import java.io.Serializable;

public class Deportistas implements Serializable {

    private String codigo;
    private String nombre;
    private String deporte;
    public Deportistas(String nombre,String codigo, String deporte)
    {
        this.nombre = nombre;
        this.codigo = codigo;
        this.deporte = deporte;
    }
    public String getNombre(){return this.nombre;}
    public String getCodigo(){return this.codigo;}
    public String getDeporte(){return this.deporte;}
}
