package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Texto extends AppCompatActivity {
    int angulo = 45;

    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        tvMensaje = findViewById(R.id.tvMensaje);
    }

    public void rotar(View v) {
        tvMensaje.setRotation(v.getRotation() + angulo);
    }
}
