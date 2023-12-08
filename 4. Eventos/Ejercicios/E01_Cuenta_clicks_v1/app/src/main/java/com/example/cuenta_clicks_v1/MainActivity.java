package com.example.cuenta_clicks_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMensaje;
    private Button btnPulsar;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btnPulsar = findViewById(R.id.btnPulsar);

        //Auxiliar
        Auxiliar escuchador = new Auxiliar();

        //Asignar el escuchador a la vista correspondiente
        btnPulsar.setOnClickListener(escuchador);
    }

    private class Auxiliar implements View.OnClickListener {

        public void onClick(View view) {
            contador++;
            if (contador == 1){
                tvMensaje.setText("Has pulsado " + contador + " vez");
            }

            if(contador > 1){
                tvMensaje.setText("Has pulsado " + contador + " veces");
            }
        }
    }
}