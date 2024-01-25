package com.example.listados;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListView_1_Activity extends AppCompatActivity {
    private ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view1);

        lvPlanetas = findViewById(R.id.lvPlanetas1);

        //ESCUCHADOR DE LA LISTVIEW
        lvPlanetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String elementoSeleccionado = parent.getItemAtPosition(position).toString();
                Toast.makeText(ListView_1_Activity.this, "Has elegido" + "\n" + elementoSeleccionado, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
