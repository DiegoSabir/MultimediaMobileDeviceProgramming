package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rdTexto, rdImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdTexto = findViewById(R.id.rdTexto);
        rdImagen = findViewById(R.id.rdImagen);
    }

    public void aceptar(View v){
        Intent intent;
        if (rdTexto.isChecked()){
            intent = new Intent(this, Texto.class);
        }
        else {
            intent = new Intent(this, Imagen.class);
        }
        startActivity(intent);
    }
}