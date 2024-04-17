package com.example.ejercicio9_listas_v2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lvPantallas, lvPaddings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontrar los ListViews
        lvPantallas = findViewById(R.id.lvPantallas);
        lvPaddings = findViewById(R.id.lvPaddings);

        //Crear instancia del adaptador personalizado
        Adaptador adaptadorPantallas = new Adaptador(this, R.layout.lista,
                getResources().getStringArray(R.array.pantallas));

        Adaptador adaptadorPaddings = new Adaptador(this, R.layout.lista,
                getResources().getStringArray(R.array.paddings));

        //Asignar el adaptador a la vista
        lvPantallas.setAdapter(adaptadorPantallas);
        lvPaddings.setAdapter(adaptadorPaddings);

        //Escuchador
        lvPantallas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedOption = (String) adapterView.getItemAtPosition(i);
                if (selectedOption.equals("6 colores")) {
                    lvPaddings.setVisibility(View.VISIBLE);
                    lvPantallas.setVisibility(View.GONE);
                }
            }
        });
    }
}