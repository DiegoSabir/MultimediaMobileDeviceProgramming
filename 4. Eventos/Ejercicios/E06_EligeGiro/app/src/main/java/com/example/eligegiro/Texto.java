package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Texto extends AppCompatActivity {
    private static final String ROTATION_STATE = "rotationState";
    int angulo;
    private TextView tvMensaje;
    private float rotationValue = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

        tvMensaje = findViewById(R.id.tvMensaje);

        angulo = Integer.parseInt(getIntent().getStringExtra("valor"));

        if (savedInstanceState != null) {
            rotationValue = savedInstanceState.getFloat(ROTATION_STATE);
            tvMensaje.setRotation(rotationValue);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        // Guardar el estado actual de la rotación al cambiar la configuración
        outState.putFloat(ROTATION_STATE, rotationValue);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restaurar la rotación al recuperar el estado guardado
        rotationValue = savedInstanceState.getFloat(ROTATION_STATE);
        tvMensaje.setRotation(rotationValue);
    }

    public void rotar(View v) {
        rotationValue += angulo;
        tvMensaje.setRotation(rotationValue);
    }
}
