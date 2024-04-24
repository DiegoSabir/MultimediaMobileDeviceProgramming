package com.example.ejercicio10_listas_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private ListView lvPantallas, lvPaddings;
    ArrayAdapter<String> adaptadorPantallas, adaptadorPaddings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontrar los ListViews
        lvPantallas = findViewById(R.id.lvPantallas);
        lvPaddings = findViewById(R.id.lvPaddings);

        adaptadorPantallas = new ArrayAdapter<String>(this,
                R.layout.fila,
                R.id.tvOpcionFila,
                getResources().getStringArray(R.array.pantallas));

        adaptadorPaddings = new ArrayAdapter<String>(this,
                R.layout.fila,
                R.id.tvOpcionFila,
                getResources().getStringArray(R.array.paddings));

        lvPantallas.setAdapter(adaptadorPantallas);
        lvPaddings.setAdapter(adaptadorPaddings);

        lvPantallas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String opcionPantalla = (String) adapterView.getItemAtPosition(i);
                Intent intent = null;
                switch (opcionPantalla) {
                    case "4 colores":
                        intent = new Intent(MainActivity.this, Pantalla1.class);
                        break;

                    case "6 colores":
                        lvPaddings.setVisibility(View.VISIBLE);
                        lvPantallas.setVisibility(View.GONE);
                        break;

                    case "9 colores":
                        intent = new Intent(MainActivity.this, Pantalla4.class);
                        break;
                }
                if (intent != null) {
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });

        lvPaddings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String opcionPadding = (String) adapterView.getItemAtPosition(i);
                Intent intent = null;
                switch (opcionPadding) {
                    case "Sin padding":
                        intent = new Intent(MainActivity.this, Pantalla2.class);
                        break;

                    case "Con padding":
                        intent = new Intent(MainActivity.this, Pantalla3.class);
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
                    lvPantallas.setVisibility(View.VISIBLE);
                    lvPaddings.setVisibility(View.GONE);
                    finish();
                }
            }
        }
    }
}