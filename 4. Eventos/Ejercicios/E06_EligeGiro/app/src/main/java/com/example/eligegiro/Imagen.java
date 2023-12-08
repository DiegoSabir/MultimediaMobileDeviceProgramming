package com.example.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Imagen extends AppCompatActivity {
    int angulo;

    private ImageView ivEmoticono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        ivEmoticono = findViewById(R.id.ivEmoticono);

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
