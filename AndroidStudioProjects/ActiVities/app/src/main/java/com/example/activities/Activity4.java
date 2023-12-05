package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    TextView tvMensaje4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //recuperar el dato enviado desde la Activity 1 mediante el intent
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        //extraer el dato
        String mensajeRecibido = bundle.getString("mensaje");
        tvMensaje4= findViewById(R.id.tvMensaje4);
        tvMensaje4.setText(mensajeRecibido);
    }
}