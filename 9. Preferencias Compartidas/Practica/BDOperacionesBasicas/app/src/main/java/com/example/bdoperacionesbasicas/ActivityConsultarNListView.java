package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityConsultarNListView extends AppCompatActivity {
    private Button btnFinConsultarNListView;
    private ListView lvListaUsuarios;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_nlist_view);

        btnFinConsultarNListView=findViewById(R.id.btnFinConsultarNListView);
        lvListaUsuarios=findViewById(R.id.lvListaUsuarios);

        btnFinConsultarNListView.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getReadableDatabase();

        consultarN();
    }

    private void consultarN(){
        //metodo parametrizado
        ArrayList<String> arrayListUsuarioss = new ArrayList<String>();
        String[] datosARecuperar = {"codigo", "nombre"};
        Cursor cursorNParametrizado = db.query("usuarios", datosARecuperar, null, null, null, null, null);
        if (cursorNParametrizado.moveToFirst()) {
            do {
                int codigo = cursorNParametrizado.getInt(0);
                String nombre = cursorNParametrizado.getString(1);
                String usuario=codigo+"-"+nombre;
                arrayListUsuarioss.add(usuario);
            }while(cursorNParametrizado.moveToNext());
            ArrayAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListUsuarioss);
            lvListaUsuarios.setAdapter(adaptador);
        } else {
            Toast.makeText(ActivityConsultarNListView.this, "Datos inexistentes\nConsulta errónea", Toast.LENGTH_SHORT).show();
        }
        cursorNParametrizado.close();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFinConsultarNListView:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}