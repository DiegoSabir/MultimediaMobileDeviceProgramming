package com.example.cuenta_clicks_v1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvMensaje;
    private Button btnPulsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btnPulsar = findViewById(R.id.btnPulsar);

        Auxiliar escuchadorPulsar = new Auxiliar();

        btnPulsar.setOnClickListener(escuchadorPulsar);
    }

    private class Auxiliar implements View.OnClickListener{
        int contador = 0;
        @Override
        public void onClick(View view){
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