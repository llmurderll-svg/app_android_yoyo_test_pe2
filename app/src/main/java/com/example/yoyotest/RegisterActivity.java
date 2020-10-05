package com.example.yoyotest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText nombre, apellidop, apellidom, correo, password;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    Button btnConfirmar;
    String url = "https://tinnitusperu.000webhostapp.com/app_yoyo_test/registro.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        requestQueue = Volley.newRequestQueue(RegisterActivity.this);
        nombre = findViewById(R.id.edtNombre);
        apellidop = findViewById(R.id.edtApellidoPaterno);
        apellidom = findViewById(R.id.edtApellidoMaterno);
        correo = findViewById(R.id.edtCorreo);
        password = findViewById(R.id.edtPassword);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        limpiarVariables();
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarRegistro();
            }
        });

    }
    public void validarRegistro(){
        final String nom = nombre.getText().toString();
        final String app = apellidop.getText().toString();
        final String apm = apellidom.getText().toString();
        final String cor = correo.getText().toString();
        final String pas = password.getText().toString();
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("CORRECTAMENTE")){
                            Toast.makeText(RegisterActivity.this,"todo bien",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this,"todo mal",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegisterActivity.this,"No se pudo conectar",Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("nombre",nom);
                params.put("apellidop",app);
                params.put("apellidom",apm);
                params.put("correo",cor);
                params.put("clave",pas);
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    public void limpiarVariables(){
        nombre.setText("");apellidop.setText("");apellidom.setText("");correo.setText("");password.setText("");
    }
}