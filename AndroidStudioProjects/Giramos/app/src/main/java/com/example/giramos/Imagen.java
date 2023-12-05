package com.example.giramos;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Imagen extends AppCompatActivity {

    int rotacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        rotacion = Integer.parseInt(getIntent().getStringExtra("valor"));
    }

    public void rotar(View v){
        if (v.getRotation() < 360){
            v.setRotation(v.getRotation()+rotacion);
        } else{
            v.setRotation(rotacion);
        }
    }
}