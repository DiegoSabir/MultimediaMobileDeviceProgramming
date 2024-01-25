package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Spinner5_DinamicoTrue extends AppCompatActivity {
    private Spinner sPlanetas;
    private ArrayList<String> arrayListPlanetas;
    private EditText etPlanetas;
    private Button Confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner5_dinamico_true);
        sPlanetas = findViewById(R.id.sPlanetas5);
        etPlanetas = findViewById(R.id.etPlanetas);
        Confirmar = findViewById(R.id.Confirmar);
        arrayListPlanetas = new ArrayList<>();
        arrayListPlanetas.add(String.valueOf(etPlanetas.getText()));
        ArrayAdapter<String> array = new ArrayAdapter<>(
                this,android.R.layout.simple_spinner_dropdown_item,arrayListPlanetas
        );
        sPlanetas.setAdapter(array);
        Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(etPlanetas.getText().toString().isEmpty()){
                   Toast.makeText(Spinner5_DinamicoTrue.this,"Introduzca Intel",Toast.LENGTH_SHORT).show();
               }else if(!etPlanetas.getText().toString().isEmpty()){
                   if (sPlanetas.getVisibility()!=View.VISIBLE){
                       sPlanetas.setVisibility(View.VISIBLE);
                   }
                   arrayListPlanetas.add(etPlanetas.getText().toString());
                   array.notifyDataSetChanged();
                   etPlanetas.setText("");
                   sPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                       @Override
                       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                           String elementosSeleccionado = sPlanetas.getSelectedItem().toString();
                           //Podemos acceder al elemento seleccionado desde el propio adaptador
                           String elementosSeleccionado2 = parent.getItemAtPosition(position).toString();
                           Toast.makeText(Spinner5_DinamicoTrue.this,"has elegido " +elementosSeleccionado + "\n" + elementosSeleccionado2 ,Toast.LENGTH_SHORT).show();
                       }

                       @Override
                       public void onNothingSelected(AdapterView<?> parent) {
                           // no tiene interés para nosotros
                       }
                   });
               }
            }
        });
    }
}