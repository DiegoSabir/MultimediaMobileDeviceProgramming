package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class Spinner_1_Activity extends AppCompatActivity{

    private Spinner spPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner1);

        spPlanetas = findViewById(R.id.spPlanetas1);

        // ESCUCHADOR DEL SPINNER
        spPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String elementoSeleccionado = spPlanetas.getSelectedItem().toString();

                //PODEMOS ACCEDER AL ELEMENTO SELECCIONADO DESDE EL PROPIO ADAPTADOR
                String elementoSeleccionado2 = parent.getItemAtPosition(position).toString();

                Toast.makeText(Spinner_1_Activity.this,"Has elegido" + elementoSeleccionado + "\n" + elementoSeleccionado2,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //NO TIENE INTERES PARA NOSOTROS
            }
        });
    }

}
