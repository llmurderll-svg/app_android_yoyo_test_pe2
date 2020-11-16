package com.example.yoyotest.Internet;

import android.util.Log;

import com.example.yoyotest.Clases.Deportistas;
import com.example.yoyotest.Clases.Nombre;
import com.example.yoyotest.Clases.Parametros;
import com.example.yoyotest.Clases.tiempos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONUtils {
    public static List<Deportistas> parseJsonDeportistas(String json) throws JSONException
    {
        final String CODIGO="codigo";
        final String NOMBRE="nombre";
        final String DEPORTE="deporte";
        String[] parsedData = null;
        String jsonT = json.replace("\\","");
        String jsonTe=json.replace("u00bf","¿");
        JSONArray jsonArray = new JSONArray(jsonTe);
        parsedData = new String[jsonArray.length()];
        Log.e("parsedData",Integer.toString(parsedData.length));
        List<Deportistas> my_data = new ArrayList<Deportistas>();
        for(int i = 0;i<jsonArray.length();i++)
        {
            JSONObject obj = jsonArray.getJSONObject(i);
            my_data.add(new Deportistas(obj.getString(CODIGO),obj.getString(NOMBRE),obj.getString(DEPORTE)));
        }
        return my_data;
    }

    public static List<tiempos> parseJsonTiempos(String json) throws JSONException
    {
        final String TIEMPOTRAMO="tiempotramo";
        final String VELPROM="velprom";
        String[] parsedData = null;
        String jsonT = json.replace("\\","");
        String jsonTe=json.replace("u00bf","¿");
        JSONArray jsonArray = new JSONArray(jsonTe);
        parsedData = new String[jsonArray.length()];
        Log.e("parsedData",Integer.toString(parsedData.length));
        List<tiempos> my_data = new ArrayList<tiempos>();
        for(int i = 0;i<jsonArray.length();i++)
        {
            JSONObject obj = jsonArray.getJSONObject(i);
            my_data.add(new tiempos(obj.getString(TIEMPOTRAMO),obj.getString(VELPROM)));
        }
        return my_data;
    }

    public static Parametros parseJsonParametros(String json) throws JSONException
    {
        final String TIEMPOTOTAL="tiempototal";
        final String DISTANCIA="distancia";
        final String VOMAX = "vomax";
        String[] parsedData = null;
        String jsonT = json.replace("\\","");
        String jsonTe=json.replace("u00bf","¿");
        JSONArray jsonArray = new JSONArray(jsonTe);
        parsedData = new String[jsonArray.length()];
        Log.e("parsedData",Integer.toString(parsedData.length));
        Parametros my_data;
        JSONObject obj = jsonArray.getJSONObject(0);
        my_data= (new Parametros(obj.getString(TIEMPOTOTAL),obj.getString(DISTANCIA),obj.getString(VOMAX)));
        return my_data;
    }
    public static Nombre parseNombre(String json) throws JSONException
    {
        final String NOMBRE="nombre";
        final String APELLIDO="apellidop";
        String[] parsedData = null;
        String jsonT = json.replace("\\","");
        String jsonTe=json.replace("u00bf","¿");
        JSONArray jsonArray = new JSONArray(jsonTe);
        parsedData = new String[jsonArray.length()];
        Log.e("parsedData",Integer.toString(parsedData.length));
        Nombre my_data;
        JSONObject obj = jsonArray.getJSONObject(0);
        my_data= (new Nombre(obj.getString(NOMBRE),obj.getString(APELLIDO)));
        return my_data;
    }
}

