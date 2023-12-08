package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rdTexto, rdImagen;
    EditText etAngulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdTexto = findViewById(R.id.rdTexto);
        rdImagen = findViewById(R.id.rdImagen);

        etAngulo = findViewById(R.id.etAngulo);
    }

    public void aceptar(View v){
        if (!etAngulo.getText().toString().isEmpty()){
            if(Integer.parseInt(etAngulo.getText().toString()) > 90 || Integer.parseInt(etAngulo.getText().toString()) < 10) {
                Toast.makeText(this, "Valor fuera de rango", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent;
                if (rdTexto.isChecked()){
                    intent = new Intent(this, Texto.class);
                }
                else {
                    intent = new Intent(this, Imagen.class);
                }
                intent.putExtra("valor", etAngulo.getText().toString());
                startActivity(intent);
            }
        }
        else {
            Toast.makeText(this, "Debes introducir un valor", Toast.LENGTH_SHORT).show();
        }
    }
}