package com.example.learnchemistry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Insertar extends AppCompatActivity {
    private LinearLayout llComprobacion, llResultadoComprobacion;
    private Button btnComprobar, btnContinuar;
    private RadioGroup rgOpciones;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);


    }
}
