package com.example.ejercicio7_spinners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private Spinner spPantallas, spPadding;
    private String pantalla, padding;
    private static final int REQUEST_CODE = 1;
    private Button btnAdelante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spPantallas = findViewById(R.id.spPantallas);
        spPadding = findViewById(R.id.spPadding);

        btnAdelante = findViewById(R.id.btnAdelante);

        spPantallas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pantalla = adapterView.getItemAtPosition(i).toString();

                if (pantalla.equals("6 colores")) {
                    spPadding.setVisibility(View.VISIBLE);
                }
                else {
                    spPadding.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spPadding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                padding = adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnAdelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pantallaSeleccionada = spPantallas.getSelectedItem().toString();

                Intent intent = null;
                switch (pantallaSeleccionada) {
                    case "4 colores":
                        intent = new Intent(MainActivity.this, Pantalla1.class);
                        break;

                    case "6 colores":
                        intent = new Intent(MainActivity.this, Pantalla3.class);
                        break;

                    case "9 colores":
                        intent = new Intent(MainActivity.this, Pantalla4.class);
                        break;
                }
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 4) {
                boolean resultOk = data.getBooleanExtra("salida", false);
                if (resultOk) {
                    finish();
                }
            }
        }
    }
}
