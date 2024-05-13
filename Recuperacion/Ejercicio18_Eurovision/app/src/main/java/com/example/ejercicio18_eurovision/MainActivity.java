package com.example.ejercicio18_eurovision;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MenuActivity {
    private Button btnVerDatos;
    LinearLayout llAutoComplete;
    private ListView lvDatos, lvDatosTotalPais, lvDatosPaises;
    BBDD bd;
    AutoCompleteTextView actvPaises;
    List<Eurovision> listaResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
    }

    public void inicializar() {
        btnVerDatos = findViewById(R.id.btnVerDatos);

        lvDatos = findViewById(R.id.lvDatos);
        lvDatosTotalPais = findViewById(R.id.lvDatosTotalPais);

        llAutoComplete = findViewById(R.id.llAutoComplete);
        actvPaises = findViewById(R.id.actvPaises);
        lvDatosPaises = findViewById(R.id.lvDatosPaises);

        bd = new BBDD(this);

        obtenerDatos();

        List<Eurovision> listaPaises = bd.obtenerPais();
        List<String> nombresPaises = new ArrayList<>();

        for (Eurovision eurovision : listaPaises) {
            nombresPaises.add(eurovision.getPais());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, nombresPaises);

        actvPaises.setAdapter(adaptador);
        actvPaises.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adaptador.getFilter().filter(s);
                String textoBusqueda = s.toString();
                List<Eurovision> datosDelPais = bd.obtenerResultadosPorPais(textoBusqueda);
                Adaptador resultado = new Adaptador(MainActivity.this, datosDelPais);
                lvDatosPaises.setAdapter(resultado);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    public void onClick(View view) {
        btnVerDatos.setVisibility(View.GONE);
        lvDatos.setVisibility(View.VISIBLE);
    }


    public void obtenerDatos() {
        listaResultados = bd.obtenerTodosResultados();
        Adaptador adaptador = new Adaptador(this, listaResultados);
        lvDatos.setAdapter(adaptador);
    }


    public void obtenerDatosTotalPais() {
        btnVerDatos.setVisibility(View.GONE);
        lvDatosTotalPais.setVisibility(View.VISIBLE);
        llAutoComplete.setVisibility(View.GONE);
        lvDatos.setVisibility(View.GONE);

        listaResultados = bd.obtenerTotalPais();
        AdaptadorTotalPais adaptador = new AdaptadorTotalPais(this, listaResultados);
        lvDatosTotalPais.setAdapter(adaptador);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ctx_opc1:
                btnVerDatos.setVisibility(View.GONE);
                lvDatosTotalPais.setVisibility(View.GONE);
                llAutoComplete.setVisibility(View.VISIBLE);
                lvDatos.setVisibility(View.GONE);
                return true;

            case R.id.ctx_opc2:
                obtenerDatosTotalPais();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}