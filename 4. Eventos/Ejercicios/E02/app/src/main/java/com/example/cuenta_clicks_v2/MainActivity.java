package com.example.cuenta_clicks_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvMensaje;
    private Button btnPulsar;
    private Button btnFinalizar;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btnPulsar = findViewById(R.id.btnPulsar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnPulsar.setOnClickListener(this);
        btnFinalizar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnPulsar){
            contador++;
            if (contador == 1){
                tvMensaje.setText("Has pulsado " + contador + " vez");
            }
            if(contador > 1){
                tvMensaje.setText("Has pulsado " + contador + " veces");
            }
        }
        else if (v.getId() == R.id.btnFinalizar){
            contador = 0;
            tvMensaje.setText("Has pulsado " + contador + " veces");
        }
    }
}