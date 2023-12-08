package com.example.pulsaetiqueta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);

        /** OPCION 1
        tvMensaje.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tvMensaje.setText("HOOOOOOLA!!!!");
                tvMensaje.setTextSize(40);
                tvMensaje.setBackgroundResource(R.color.lemon);
                tvMensaje.setRotation(45);
            }
        });
         */
    }

    //OPCION 2
    public void rotar(View v) {
        tvMensaje.setText("HOOOOOOLA!!!!");
        tvMensaje.setTextSize(40);
        tvMensaje.setBackgroundResource(R.color.lemon);
        tvMensaje.setRotation(45);
    }
}