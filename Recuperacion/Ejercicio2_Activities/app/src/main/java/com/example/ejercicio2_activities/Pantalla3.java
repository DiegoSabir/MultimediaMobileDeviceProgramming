package com.example.ejercicio2_activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class Pantalla3 extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        View redView = findViewById(R.id.redView);
        View yellowView = findViewById(R.id.yellowView);
        View orangeView = findViewById(R.id.orangeView);
        View greenView = findViewById(R.id.greenView);
        View blueView = findViewById(R.id.blueView);
        View purpleView = findViewById(R.id.purpleView);

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

        orangeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.orange));
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

        purpleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnColor(ContextCompat.getColor(getApplicationContext(), R.color.purple));
            }
        });
    }

    private void returnColor(int color) {
        Intent intent = new Intent(Pantalla3.this, Auxiliar.class);
        intent.putExtra("color", color);
        intent.putExtra("fromActivity", "Pantalla3");
        startActivity(intent);
    }
}
