package com.example.textviewporcodigo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
//paquete que contiene la clase TextView

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        // Se sustituye la linea anterior por las siguientes
        // Crear una instancia de la clase TextView
        TextView etiqueta1 = new TextView(this);
        // Establecemos el valor del string
        etiqueta1.setText("TextView desde código");
        // Modificamos tamaño y color
        etiqueta1.setTextSize(25);
        etiqueta1.setTextColor(0xFFFF0000);
        // Colocamos la vista TextView en el layout de la actividad
        setContentView(etiqueta1);
    }
}
