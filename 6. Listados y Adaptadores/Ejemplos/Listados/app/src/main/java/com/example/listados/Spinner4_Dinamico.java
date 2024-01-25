package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner4_Dinamico extends AppCompatActivity {
    private Spinner sPlanetas;
    private ArrayList<String> arrayListPlanteras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner4_dinamico);
        sPlanetas = findViewById(R.id.sPlanetas4);
        //Simulacion de la carga dinamica del string
        arrayListPlanteras = new ArrayList();
        arrayListPlanteras.add("Mercurio");
        arrayListPlanteras.add("Venus");
        arrayListPlanteras.add("Terra");
        arrayListPlanteras.add("Marte");
        arrayListPlanteras.add("Jupiter");
        arrayListPlanteras.add("Saturno");
        arrayListPlanteras.add("Urano");
        arrayListPlanteras.add("Neptuno");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item,arrayListPlanteras
        );
        sPlanetas.setAdapter(adapter);

        sPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elementosSeleccionado = sPlanetas.getSelectedItem().toString();
                //Podemos acceder al elemento seleccionado desde el propio adaptador
                String elementosSeleccionado2 = parent.getItemAtPosition(position).toString();
                Toast.makeText(Spinner4_Dinamico.this,"has elegido " +elementosSeleccionado + "\n" + elementosSeleccionado2 ,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // no tiene interés para nosotros
            }
        });
    }
}