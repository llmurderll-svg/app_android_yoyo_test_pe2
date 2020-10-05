package com.example.yoyotest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.yoyotest.Adaptadores.DeportistasAdapter;
import com.example.yoyotest.Clases.Deportistas;
import com.example.yoyotest.Internet.JSONUtils;
import com.example.yoyotest.Internet.NetworkManager;

import java.util.ArrayList;
import java.util.List;

public class DeportistasActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button agregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportistas);
        recyclerView=findViewById(R.id.recycler_deportistas);
        agregar = findViewById(R.id.btnAgregar);
        obtenerDeportistas();
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeportistasActivity.this, RegistrodeportistasActivity.class);
                startActivity(intent);
            }
        });
    }
    private void obtenerDeportistas(){
        String requestURL= "https://tinnitusperu.000webhostapp.com/app_yoyo_test/deportistas.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET,requestURL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                List<Deportistas> my_data = new ArrayList<Deportistas>();
                try
                {
                    my_data = JSONUtils.parseJsonDeportistas(response);
                    LinearLayoutManager layout = new LinearLayoutManager(DeportistasActivity.this);
                    recyclerView.setLayoutManager(layout);
                    DeportistasAdapter adapter = new DeportistasAdapter(DeportistasActivity.this, my_data);
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
        NetworkManager.getInstance(DeportistasActivity.this).getQueue().add(stringRequest);
    }
}