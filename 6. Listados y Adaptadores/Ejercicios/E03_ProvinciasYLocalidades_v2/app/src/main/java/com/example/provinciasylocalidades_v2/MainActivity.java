package com.example.provinciasylocalidades_v2;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private LinearLayout containerLocalidades;
    private AutoCompleteTextView actvProvincia;
    private Spinner spLocalidades;
    private ArrayList<String> contentsLocalidades;
    private ArrayAdapter<String> adaptadorProvincias;
    private ArrayAdapter<String> adaptadorLocalidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup
        this.containerLocalidades = findViewById(R.id.containerLocalidades);
        this.spLocalidades = findViewById(R.id.spLocalidades);
        this.actvProvincia = findViewById(R.id.actvProvincias);

        this.containerLocalidades.setVisibility(View.GONE);

        this.contentsLocalidades = new ArrayList<>();

        this.adaptadorProvincias = new ArrayAdapter<>(this , android.R.layout.simple_spinner_dropdown_item , getResources().getStringArray(R.array.provincias));
        this.actvProvincia.setAdapter(adaptadorProvincias);

        this.adaptadorLocalidades = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, contentsLocalidades);
        spLocalidades.setAdapter(adaptadorLocalidades);

        this.containerLocalidades.setVisibility(View.GONE);

        //Listeners
        this.spLocalidades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Provincia: " + actvProvincia.getText().toString() + "\nLocalidad: " + spLocalidades.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        this.actvProvincia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switchInput(actvProvincia.getText().toString());
            }
        });
    }

    private void switchInput(String s) {
        this.contentsLocalidades.clear();

        switch (s) {
            case "A Coruña":
                this.llenarLocalidades(getResources().getStringArray(R.array.localidadesACoruña));
                break;

            case "Pontevedra":
                this.llenarLocalidades(getResources().getStringArray(R.array.localidadesLugo));
                break;

            case "Lugo":
                this.llenarLocalidades(getResources().getStringArray(R.array.localidadesPontevedra));
                break;

            case "Ourense":
                this.llenarLocalidades(getResources().getStringArray(R.array.localidadesOurense));
                break;

            default:
                Toast.makeText(this, "Has seleccionado: " + s, Toast.LENGTH_SHORT).show();
                containerLocalidades.setVisibility(View.GONE);
        }
    }

    private void llenarLocalidades(String[] arr){
        Collections.addAll(this.contentsLocalidades, arr);
        containerLocalidades.setVisibility(View.VISIBLE);
        this.adaptadorLocalidades.notifyDataSetChanged();
    }
}