package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Spinner3_FromRecursos extends AppCompatActivity {
    private Spinner sPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner3_from_recursos);
        sPlanetas = findViewById(R.id.sPlanetas3);
        //metodo createFromResource
        /*
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(
                this, R.array.planetas, android.R.layout.simple_spinner_dropdown_item
        );*/
        //Capturando el recurso mediante getResources
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.planetas)
        );

        // asignar el adaptador al spinner
        sPlanetas.setAdapter(adaptador);

    }
}