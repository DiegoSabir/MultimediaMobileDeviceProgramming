package com.example.cuenta_clicks_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMensaje;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMensaje = findViewById(R.id.tvMensaje);
    }

    public void pulsar(View view) {
        if (!tvMensaje.getText().toString().isEmpty() && contador == 0) {
            tvMensaje.setText("");
        }
        contador++;
    }

    public void finalizar(View view) {
        if (contador == 1) {
            tvMensaje.setText("Has pulsado " + contador + " vez");
        }
        else {
            tvMensaje.setText("Has pulsado " + contador + " veces");
        }
        contador = 0;
    }
}