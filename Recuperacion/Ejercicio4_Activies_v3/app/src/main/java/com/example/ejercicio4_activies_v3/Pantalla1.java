package com.example.ejercicio4_activies_v3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Pantalla1 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        View redView = findViewById(R.id.redView);
        View yellowView = findViewById(R.id.yellowView);
        View greenView = findViewById(R.id.greenView);
        View blueView = findViewById(R.id.blueView);

        redView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            }
        });

        yellowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.yellow));
            }
        });

        greenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
            }
        });

        blueView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
            }
        });
    }

    private void returnColor(int color) {
        Intent intent = new Intent(Pantalla1.this, Auxiliar.class);
        intent.putExtra("color", color);
        startActivity(intent);
    }
}