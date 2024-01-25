package com.example.provinciasylocalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spProvincias;
    private Spinner spLocalidades;
    private ArrayAdapter<String> adaptador;
    private String[] arrayLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spProvincias = findViewById(R.id.spProvincias);
        spLocalidades = findViewById(R.id.spLocalidades);

        spProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cargaSpinnerLocalidades(i);
                provincia = adapterView.getItemAtPosition(i).toString;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                localidad = adapterView.getItemAtPosition().toString;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        public void cargaSpinnerLocalidades(int i){

            switch (i){
                case 0:
                    arrayLocalidades = getResources().getStringArray(R.array.localidadesACoruña);
                    break;
                case 1:
                    arrayLocalidades = getResources().getStringArray(R.array.localidadesLugo);
                    break;
                case 2:
                    arrayLocalidades = getResources().getStringArray(R.array.localidadesPontevedra);
                    break;
                case 3:
                    arrayLocalidades = getResources().getStringArray(R.array.localidadesOurense);
                    break;
            }

            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                    this, android.R.layout.simple_spinner_dropdown_item, arrayLocalidades);
            spLocalidades.setAdapter(adaptador);
        }
    }
}
