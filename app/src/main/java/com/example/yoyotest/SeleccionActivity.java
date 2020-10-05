package com.example.yoyotest;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SeleccionActivity extends AppCompatActivity {
    Button prueba, registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        registro = findViewById(R.id.btnDeporRegistrados);
        prueba = findViewById(R.id.btnInicioPrueba);
        prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionActivity.this, PruebaActivity.class);
                startActivity(intent);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeleccionActivity.this, DeportistasActivity.class);
                startActivity(intent);
            }
        });
    }
}