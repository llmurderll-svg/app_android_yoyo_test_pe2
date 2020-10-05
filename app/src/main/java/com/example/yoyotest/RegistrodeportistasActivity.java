package com.example.yoyotest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegistrodeportistasActivity extends AppCompatActivity {
    EditText nombre, apellidop, apellidom, codigo, deporte, edad, altura, peso, sexo;
    Button registrar;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    String url = "https://tinnitusperu.000webhostapp.com/app_yoyo_test/registrar_deportista.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrodeportistas);
        requestQueue = Volley.newRequestQueue(RegistrodeportistasActivity.this);
        nombre = findViewById(R.id.edtNombre);
        apellidop = findViewById(R.id.edtApellidoPaterno);
        apellidom = findViewById(R.id.edtApellidoMaterno);
        codigo = findViewById(R.id.edtCodigo);
        deporte = findViewById(R.id.edtDeporte);
        edad = findViewById(R.id.edtEdad);
        altura = findViewById(R.id.edtAltura);
        peso = findViewById(R.id.edtPeso);
        sexo = findViewById(R.id.edtSexo);
        registrar = findViewById(R.id.btnRegistrar);
        limpiarVariables();
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRegistroDeportista();
            }
        });
    }

    private void limpiarVariables(){
        nombre.setText("");apellidop.setText("");apellidom.setText("");codigo.setText("");deporte.setText("");edad.setText("");altura.setText("");peso.setText("");sexo.setText("");
    }

    private void validarRegistroDeportista(){
        final String nom = nombre.getText().toString();
        final String app = apellidop.getText().toString();
        final String apm = apellidom.getText().toString();
        final String cod = codigo.getText().toString();
        final String dep = deporte.getText().toString();
        final String eda = edad.getText().toString();
        final String alt = altura.getText().toString();
        final String pes = peso.getText().toString();
        final String sex = sexo.getText().toString();
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("CORRECTAMENTE")){
                            Toast.makeText(RegistrodeportistasActivity.this,"se registro correctamente",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(RegistrodeportistasActivity.this,"No se ha podido registrar",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrodeportistasActivity.this,"No se pudo conectar",Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre",nom);
                params.put("apellidop",app);
                params.put("apellidom",apm);
                params.put("codigo",cod);
                params.put("deporte",dep);
                params.put("edad",eda);
                params.put("altura",alt);
                params.put("peso",pes);
                params.put("sexo",sex);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}