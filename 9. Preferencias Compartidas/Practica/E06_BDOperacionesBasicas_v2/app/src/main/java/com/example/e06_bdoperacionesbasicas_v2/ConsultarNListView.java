package com.example.e06_bdoperacionesbasicas_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConsultarNListView extends AppCompatActivity {
    /*
    Se declaran variables para:
     - El boton (btnFinConsultarNListView) de finalizar consulta
     - La lista de usuarios (lvListaUsuarios) de la interfaz de usuario
     - Así como para la base de datos SQLite (db).
    */
    private Button btnFinConsultarNListView;
    private ListView lvListaUsuarios;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_nlist_view);

        // Se obtienen referencias a los elementos de la interfaz de usuario.
        btnFinConsultarNListView=findViewById(R.id.btnFinConsultarNListView);
        lvListaUsuarios=findViewById(R.id.lvListaUsuarios);

        // Se asigna un listener al botón de finalizar consulta.
        btnFinConsultarNListView.setOnClickListener(clickListener);

        // Se instancia un objeto AuxiliarDB para acceder a la base de datos SQLite.
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Se obtiene la base de datos en modo lectura.
        db = auxiliarDB.getReadableDatabase();

        // Se llama al método consultarN para obtener y mostrar la lista de usuarios.
        consultarN();
    }

    private void consultarN(){
        //METODO PARAMETRIZADO

        // Se crea un ArrayList para almacenar los usuarios.
        ArrayList<String> arrayListUsuarioss = new ArrayList<String>();

        // Se definen las columnas a recuperar de la tabla usuarios.
        String[] datosARecuperar = {"codigo", "nombre"};

        // Se realiza la consulta a la base de datos.
        Cursor cursorNParametrizado = db.query("usuarios", datosARecuperar, null, null, null, null, null);

        // Se verifica si se obtuvieron resultados de la consulta.
        if (cursorNParametrizado.moveToFirst()) {
            // Se recorre el cursor para obtener cada usuario.
            do {
                // Se obtienen el código y el nombre del usuario.
                int codigo = cursorNParametrizado.getInt(0);
                String nombre = cursorNParametrizado.getString(1);

                // Se forma un string con el código y el nombre del usuario.
                String usuario=codigo+"-"+nombre;

                // Se agrega el usuario al ArrayList.
                arrayListUsuarioss.add(usuario);
            }
            while(cursorNParametrizado.moveToNext());

            // Se crea un adaptador para el ListView utilizando el ArrayList de usuarios.
            ArrayAdapter adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayListUsuarioss);

            // Se asigna el adaptador al ListView para mostrar la lista de usuarios.
            lvListaUsuarios.setAdapter(adaptador);
        }
        else {
            // Si no se encontraron usuarios, se muestra un mensaje de error.
            Toast.makeText(ConsultarNListView.this, "Datos inexistentes\nConsulta errónea", Toast.LENGTH_SHORT).show();
        }
        // Se cierra el cursor después de usarlo.
        cursorNParametrizado.close();
    }

    // Listener para el botón de finalizar consulta.
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFinConsultarNListView:
                    // Se cierra la base de datos y se finaliza la actividad.
                    db.close();
                    finish();
                    break;
            }
        }
    };
}
