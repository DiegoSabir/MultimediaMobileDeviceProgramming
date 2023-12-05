package com.example.giramos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Texto extends AppCompatActivity {

    int rotacion = 45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);

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