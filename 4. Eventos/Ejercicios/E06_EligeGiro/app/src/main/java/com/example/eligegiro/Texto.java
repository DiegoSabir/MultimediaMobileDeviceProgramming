package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Texto extends AppCompatActivity {
    int angulo;

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        tvMensaje = findViewById(R.id.tvMensaje);

        angulo = Integer.parseInt(getIntent().getStringExtra("valor"));
    }

    public void rotar(View v) {
        if (v.getRotation() < 360){
            v.setRotation(v.getRotation() + angulo);
        }
        else{
            v.setRotation(angulo);
        }
    }
}
