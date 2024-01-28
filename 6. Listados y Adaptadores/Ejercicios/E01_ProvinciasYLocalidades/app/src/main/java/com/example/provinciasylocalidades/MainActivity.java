package com.example.provinciasylocalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private LinearLayout containerLocalidades;
    private Spinner spProvincias;
    private Spinner spLocalidades;

    private ArrayList<String> preloadedValues = new ArrayList<>();
    private ArrayAdapter<String> adaptadorProvincias;
    private ArrayAdapter<String> adaptadorLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup
        this.containerLocalidades = findViewById(R.id.containerLocalidades);
        this.spLocalidades = findViewById(R.id.spLocalidades);
        this.spProvincias = findViewById(R.id.spProvincias);

        this.containerLocalidades.setVisibility(View.GONE);

        this.adaptadorProvincias = new ArrayAdapter<>(this , android.R.layout.simple_spinner_dropdown_item , getResources().getStringArray(R.array.provincias));
        this.spProvincias.setAdapter(adaptadorProvincias);

        this.adaptadorLocalidades = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, preloadedValues);
        spLocalidades.setAdapter(adaptadorLocalidades);

        //Listeners
        this.spProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switchInput(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        this.spLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Provincia: " + spProvincias.getSelectedItem().toString() + "\nLocalidades: " + spLocalidades.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void switchInput(int i){
        this.preloadedValues.clear();
        switch (i){
            case 0:
                Collections.addAll(this.preloadedValues, getResources().getStringArray(R.array.localidadesACoruña));
                break;

            case 1:
                Collections.addAll(this.preloadedValues, getResources().getStringArray(R.array.localidadesLugo));
                break;

            case 2:
                Collections.addAll(this.preloadedValues, getResources().getStringArray(R.array.localidadesPontevedra));
                break;

            case 3:
                Collections.addAll(this.preloadedValues, getResources().getStringArray(R.array.localidadesOurense));
                break;
        }
        this.containerLocalidades.setVisibility(View.VISIBLE);
        this.recastAdapterLocalidades();
    }

    private void recastAdapterLocalidades(){
        this.adaptadorLocalidades.notifyDataSetChanged();
    }
}
