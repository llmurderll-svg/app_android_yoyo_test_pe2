package com.example.yoyotest.Clases;

import java.io.Serializable;

public class Parametros implements Serializable {


    private String tiempototal;
    private String distancia;
    private String vomax;
    public Parametros(String tiempototal, String distancia, String vomax)
    {
        this.tiempototal  = tiempototal;
        this.distancia  = distancia;
        this.vomax = vomax;
    }
    public String getTiempototal(){return this.tiempototal;}
    public String getDistancia(){return this.distancia;}
    public String getVomax(){return this.vomax;}
}
