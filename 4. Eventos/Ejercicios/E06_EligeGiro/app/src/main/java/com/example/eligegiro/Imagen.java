package com.example.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Imagen extends AppCompatActivity {
    private static final String ROTATION_STATE = "rotationState";
    int angulo;
    private ImageView ivEmoticono;
    private float rotationValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        ivEmoticono = findViewById(R.id.ivEmoticono);

        angulo = Integer.parseInt(getIntent().getStringExtra("valor"));

        if (savedInstanceState != null) {
            rotationValue = savedInstanceState.getFloat(ROTATION_STATE);
            ivEmoticono.setRotation(rotationValue);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putFloat(ROTATION_STATE, rotationValue);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rotationValue = savedInstanceState.getFloat(ROTATION_STATE);
        ivEmoticono.setRotation(rotationValue);
    }

    public void rotar(View v) {
        rotationValue += angulo;
        ivEmoticono.setRotation(rotationValue);
    }
}
