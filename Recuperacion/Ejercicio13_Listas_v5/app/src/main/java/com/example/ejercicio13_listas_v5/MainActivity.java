package com.example.ejercicio13_listas_v5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private ListView lvPantallas, lvPaddings;
    private ArrayList<Pantalla> arrayPantallas = new ArrayList<>();
    private ArrayList<Padding> arrayPaddings = new ArrayList<>();
    Adaptador adaptadorPantalla;
    AdaptadorPadding adaptador_Padding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarViews();
        inicializarArrays();
        inicializarListView();
        clickListenerLv();
    }

    private void inicializarViews() {
        lvPantallas = findViewById(R.id.lvPantallas);
        lvPaddings = findViewById(R.id.lvPaddings);
    }

    private void inicializarArrays() {
        String[] tvOpcionFila = getResources().getStringArray(R.array.pantallas);
        String[] tvInformacionFila = getResources().getStringArray(R.array.informacion_pantallas);
        String[] tvNumerosColoresFila = getResources().getStringArray(R.array.numero_colores);
        TypedArray arrayImagenPantallaFila = getResources().obtainTypedArray(R.array.imgPantallas);

        for (int i = 0; i < tvOpcionFila.length; i++){
            arrayPantallas.add(new Pantalla(tvOpcionFila[i], tvInformacionFila[i], tvNumerosColoresFila[i], arrayImagenPantallaFila.getResourceId(i,-1)));
        }

        String[] tvOpcionPaddingFila = getResources().getStringArray(R.array.paddings);
        TypedArray arrayImagenPaddingFila = getResources().obtainTypedArray(R.array.imgPaddings);

        for (int i = 0; i < tvOpcionPaddingFila.length; i++){
            arrayPaddings.add(new Padding(tvOpcionPaddingFila[i], arrayImagenPaddingFila.getResourceId(i,-1)));
        }
    }

    private void inicializarListView() {
        adaptadorPantalla = new Adaptador(this, R.layout.fila, arrayPantallas);
        lvPantallas.setAdapter(adaptadorPantalla);

        adaptador_Padding = new AdaptadorPadding(this, R.layout.fila_paddings, arrayPaddings);
        lvPaddings.setAdapter(adaptador_Padding);
    }

    private void clickListenerLv() {
        lvPantallas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pantalla pantallaSeleccionada = arrayPantallas.get(position);
                String opcionPantalla = pantallaSeleccionada.getOpcionFila();
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
                Padding paddingSeleccionado = arrayPaddings.get(i);
                String opcionPadding = paddingSeleccionado.getOpcionPaddingFila();
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