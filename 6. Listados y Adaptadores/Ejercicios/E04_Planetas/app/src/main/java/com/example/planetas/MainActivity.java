package com.example.planetas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lvPlanetas;
    private int[] arrayIdIvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPlanetas = findViewById(R.id.lvPlanetas);

        arrayIdIvPlanetas = new int[]{
                R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte, R.drawable.jupiter, R.drawable.saturno, R.drawable.urano, R.drawable.neptuno
        };

        AdaptorPersonalizado adapter = new AdaptorPersonalizado(
                this,R.layout.fila, getResources().getStringArray(R.array.planetas), arrayIdIvPlanetas, getResources().getStringArray(R.array.planetasDatos)
        );

        lvPlanetas.setAdapter(adapter);

        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String elementoSeleccionado = parent.getItemIdAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Has elegido" + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });

    }
}