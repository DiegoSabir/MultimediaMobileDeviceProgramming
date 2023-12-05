package com.example.rotation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int rotation=0;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = findViewById(R.id.texto);
        //auxiliar
        Auxiliar escuchador1 = new Auxiliar();
        //asignar el escuchador a la vista correspondiente
        texto.setOnClickListener(escuchador1);
    }
    private class Auxiliar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            rotation+=45;
            texto.setRotation(rotation);
            texto.setText(R.string.hola);
            texto.setTextColor(Color.GREEN);
            texto.setBackgroundColor(Color.RED);
            if (rotation>=360){
                rotation=0;
                rotation++;
            }
        }
    }
}