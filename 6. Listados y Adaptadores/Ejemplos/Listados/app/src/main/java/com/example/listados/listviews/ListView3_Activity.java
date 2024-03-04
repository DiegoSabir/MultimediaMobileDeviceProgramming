package com.example.listados.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.R;

import java.util.ArrayList;
import java.util.Collections;

public class ListView3_Activity extends AppCompatActivity {
    private ListView lvPlanetas3;
    private Button btnInsert;
    private EditText planetaInsert;
    private ArrayList<String> arrayDinamico = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);

        lvPlanetas3 = findViewById(R.id.lvPlanetas3);
        btnInsert = findViewById(R.id.btnInsert);
        planetaInsert = findViewById(R.id.planetaInsert);

        Collections.addAll(arrayDinamico, getResources().getStringArray(R.array.planetas));
        iniciarAdaptador();
        listenerListView();
    }

    private void iniciarAdaptador() {
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayDinamico);
        lvPlanetas3.setAdapter(adapter);
    }

    private void listenerListView() {
        lvPlanetas3.setOnItemClickListener((parent, view, position, id) -> {
            String result = "Has seleccionado: " + lvPlanetas3.getItemAtPosition(position).toString();
            Toast.makeText(ListView3_Activity.this, result, Toast.LENGTH_SHORT).show();
        });
    }

    public void onClick(View view) {
        String text = planetaInsert.getText().toString();

        if (text.trim().isEmpty()){
            Toast.makeText(this, "El campo debe estar lleno", Toast.LENGTH_SHORT).show();
        }
        else {
            arrayDinamico.add(text);
            adapter.notifyDataSetChanged();
            planetaInsert.setText("");
        }
    }
}
