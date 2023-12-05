package com.example.cuentaclicks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView tvMensaje;
    private int pulsaciones;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        //auxiliar
        Auxiliar escuchador1 = new Auxiliar();
        //asignar el escuchador a la vista correspondiente
        btn2.setOnClickListener(escuchador1);
        btn1.setOnClickListener(escuchador2);
    }

    private class Auxiliar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            pulsaciones++;
            tvMensaje.setText("Pulsaciones: " + pulsaciones);

        }
    }

    private View.OnClickListener escuchador2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pulsaciones=0;
            tvMensaje.setText("Pulsaciones");

        }
    };
}