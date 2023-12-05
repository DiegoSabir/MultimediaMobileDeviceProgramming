package com.example.giramos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton textoCheck, imagenCheck;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCheck = findViewById(R.id.textoCheck);
        imagenCheck = findViewById(R.id.textoImagen);
        texto = findViewById(R.id.texto);

    }

    public void aceptar(View v){
        if (!texto.getText().toString().isEmpty()){
            if(Integer.parseInt(texto.getText().toString()) > 90 || Integer.parseInt(texto.getText().toString()) < 10){
                Toast.makeText(this, "Escribe un valor valido", Toast.LENGTH_SHORT).show();
            } else{
                Intent intent;
                if (textoCheck.isChecked()){
                    intent = new Intent(this, Texto.class);
                } else{
                    intent = new Intent(this, Imagen.class);
                }
                intent.putExtra("valor", texto.getText().toString());
                startActivity(intent);
            }
        } else{
            Toast.makeText(this, "Escribe un valor", Toast.LENGTH_SHORT).show();
        }
    }
}