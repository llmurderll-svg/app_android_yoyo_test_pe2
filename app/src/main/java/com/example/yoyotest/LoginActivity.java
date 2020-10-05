package com.example.yoyotest;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity {
    EditText correo, password;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    Button btnIngresar;
    String url = "https://tinnitusperu.000webhostapp.com/app_yoyo_test/loguin.php?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        requestQueue = Volley.newRequestQueue(LoginActivity.this);
        correo = findViewById(R.id.edtCorreo);
        password = findViewById(R.id.edtPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        limpiarVariables();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarLogin();
            }
        });
    }
    public void validarLogin() {
        final String cor = correo.getText().toString();
        final String pas = password.getText().toString();
        stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("OK")) {
                            Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, SeleccionActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                            limpiarVariables();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this, "No se ha podido conectar, verifique la conexiòn a internet", Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("correo", cor);
                params.put("clave", pas);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public void limpiarVariables(){
            correo.setText("");password.setText("");
    }
}