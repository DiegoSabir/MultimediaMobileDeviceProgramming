package com.example.listados;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Spinner_2_Activity  extends AppCompatActivity {

    private Spinner spPlanetas;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        spPlanetas = findViewById(R.id.spPlanetas2);

        String[] arrayPlanetas = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};

        //UTILIZAR UN ADAPTADOR
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, arrayPlanetas);

        //ASIGNAR ADAPTADOR AL SPINNER
        spPlanetas.setAdapter(adaptador);

        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elementoSeleccionado = spPlanetas.getSelectedItem().toString();

                //PODEMOS ACCEDER AL ELEMENTO SELECCIONADO DESDE EL PROPIO ADAPTADOR
                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Spinner_2_Activity.this,"Has elegido" + elementoSeleccionado + "\n" + elementoSeleccionado2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //NO TIENE INTERES PARA NOSOTROS
            }
        });
    }
}
