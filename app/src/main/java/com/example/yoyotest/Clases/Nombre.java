package com.example.yoyotest.Clases;

import java.io.Serializable;

public class Nombre implements Serializable {


    private String nombre;
    private String apellido;
    public Nombre(String nombre, String apellido)
    {
        this.nombre  = nombre;
        this.apellido = apellido;
    }
    public String getNombre(){return this.nombre;}
    public String getapellido(){return this.apellido;}
}
