package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity3 extends AppCompatActivity {

    TextView tvMensaje3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        //recuperar el dato enviado desde la Activity 1 mediante el intent
        Intent intent = getIntent();
        //extraer el dato
        String datoRecibido = intent.getStringExtra("mensaje");
        //Visualizar dato en la TextView
        tvMensaje3=findViewById(R.id.tvMensaje3);
        tvMensaje3.setText(datoRecibido);

    }
}