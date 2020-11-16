package com.example.yoyotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.yoyotest.Adaptadores.DeportistasAdapter;
import com.example.yoyotest.Adaptadores.TiemposAdapter;
import com.example.yoyotest.Clases.Deportistas;
import com.example.yoyotest.Clases.Nombre;
import com.example.yoyotest.Clases.Parametros;
import com.example.yoyotest.Clases.tiempos;
import com.example.yoyotest.Internet.JSONUtils;
import com.example.yoyotest.Internet.NetworkManager;

import java.util.ArrayList;
import java.util.List;

public class PruebaActivity extends AppCompatActivity {
    Button ok;
    RecyclerView recyclerView ;
    EditText vomax,distancia,tiempo,nombre,alumno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        ok = findViewById(R.id.btnOK);
        recyclerView = findViewById(R.id.recycler_tiempos);
        tiempo = findViewById(R.id.tiempo);
        distancia = findViewById(R.id.distancia);
        vomax  = findViewById(R.id.vomax);
        alumno = findViewById(R.id.nombreAlumno);
        nombre = findViewById(R.id.codigoAlumno);
        nombre.setText("");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificar_nombre();

            }
        });
    }
    private void verificar_nombre(){
        String requestURL= "https://tinnitusperu.000webhostapp.com/app_yoyo_test/vernombre.php?codigo="+nombre.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.GET,requestURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Nombre my_data;
                try
                {
                    my_data = JSONUtils.parseNombre(response);
                    alumno.setText(my_data.getNombre()+" "+my_data.getapellido());
                    traer_datos();
                    traer_parametros();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Respuesta","Falla");
                    }
                });
        stringRequest.setShouldCache(false);
        NetworkManager.getInstance(PruebaActivity.this).getQueue().add(stringRequest);
    }
    private void traer_datos(){
        String requestURL= "https://tinnitusperu.000webhostapp.com/app_yoyo_test/vertiempos.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,requestURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                List<tiempos> my_data = new ArrayList<tiempos>();
                try
                {
                    my_data = JSONUtils.parseJsonTiempos(response);
                    LinearLayoutManager layout = new LinearLayoutManager(PruebaActivity.this);
                    recyclerView.setLayoutManager(layout);
                    TiemposAdapter adapter = new TiemposAdapter(PruebaActivity.this, my_data);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setHasFixedSize(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Respuesta","Falla");
                    }
                });
        stringRequest.setShouldCache(false);
        NetworkManager.getInstance(PruebaActivity.this).getQueue().add(stringRequest);
    }

    private void traer_parametros(){
        String requestURL= "https://tinnitusperu.000webhostapp.com/app_yoyo_test/verparametros.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,requestURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Parametros my_data;
                try
                {
                    my_data = JSONUtils.parseJsonParametros(response);
                    distancia.setText(my_data.getDistancia());
                    vomax.setText(my_data.getVomax());
                    tiempo.setText(my_data.getTiempototal());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Respuesta","Falla");
                    }
                });
        stringRequest.setShouldCache(false);
        NetworkManager.getInstance(PruebaActivity.this).getQueue().add(stringRequest);
    }

}