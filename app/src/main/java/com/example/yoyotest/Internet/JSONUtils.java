package com.example.yoyotest.Internet;

import android.util.Log;

import com.example.yoyotest.Clases.Deportistas;

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
}

