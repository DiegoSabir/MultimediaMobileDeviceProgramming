package com.example.listados.listviews;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listados.Planeta;
import com.example.listados.R;
import com.example.listados.adaptadores.AdaptadorPersonalizado1;
import com.example.listados.adaptadores.AdaptadorPersonalizado2;
import com.example.listados.adaptadores.AdaptadorPersonalizado3;

import java.util.ArrayList;

public class ListView6_Activity extends AppCompatActivity {

    private ListView lvPlanetas6;

    private TypedArray arrayIdFotosPlanetas;

    private ArrayList<Planeta> arrayPlanetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6);

        lvPlanetas6 = findViewById(R.id.lvPlanetas6);

        arrayIdFotosPlanetas = getResources().obtainTypedArray(R.array.iconsPlanetas);

        inicializarArrays();

        //crear instancia del adaptador personalizado
        /*AdaptadorPersonalizado2 adaptador = new AdaptadorPersonalizado2(this, R.layout.fila_diferentes_imagenes,
                getResources().getStringArray(R.array.planetas), arrayIdFotosPlanetas);*/

        AdaptadorPersonalizado3 adaptador = new AdaptadorPersonalizado3(this, R.layout.fila_diferentes_imagenes, arrayPlanetas);
        lvPlanetas6.setAdapter(adaptador);
        listenerListView();
    }

    private void inicializarArrays() {
        String[] nombresPlanetas = getResources().getStringArray(R.array.planetas);
        TypedArray fotosPlanetas = getResources().obtainTypedArray(R.array.iconsPlanetas);

        for (int i = 0; i < nombresPlanetas.length; i++){
            arrayPlanetas.add(new Planeta(nombresPlanetas[i], fotosPlanetas.getResourceId(i,-1)));
        }
    }

    private void listenerListView() {
        lvPlanetas6.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(ListView6_Activity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show());
    }
}
