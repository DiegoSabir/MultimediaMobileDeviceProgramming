package com.example.eligegiro;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Imagen extends AppCompatActivity {
    private static final String ROTATION_STATE = "rotationState";
    private static final int ANGULO = 45;
    private ImageView ivEmoticono;
    private float rotationValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);

        ivEmoticono = findViewById(R.id.ivEmoticono);

        if (savedInstanceState != null) {
            rotationValue = savedInstanceState.getFloat(ROTATION_STATE);
            ivEmoticono.setRotation(rotationValue);
        }
        /** OPCION 1
         ivEmoticono.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
        angulo += 45;
        ivEmoticono.setRotation(angulo);
        }
        });
         */
    }

    @Override
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
        ivEmoticono.setRotation(rotationValue);
    }

    //OPCION 2
    public void rotar(View v) {
        rotationValue += ANGULO;
        ivEmoticono.setRotation(rotationValue);
    }
}
