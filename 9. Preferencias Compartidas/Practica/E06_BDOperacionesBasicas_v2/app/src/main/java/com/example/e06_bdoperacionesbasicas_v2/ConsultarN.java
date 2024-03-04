package com.example.e06_bdoperacionesbasicas_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConsultarN extends AppCompatActivity {
    /*
    Se declaran variables para:
     - El boton (btnFinConsultarN) de la interfaz de usuario
     - El campo de texto (tvListaUsuarios) de la interfaz de usuario
     - Así como para la base de datos SQLite (db).
    */
    private Button btnFinConsultarN;
    private TextView tvListaUsuarios;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_n);

        // Buscar referencias de los elementos de la interfaz de usuario
        btnFinConsultarN=findViewById(R.id.btnFinConsultarN);
        tvListaUsuarios=findViewById(R.id.tvListaUsuarios);

        // Establecer listener para el botón
        btnFinConsultarN.setOnClickListener(clickListener);

        // Instanciar un objeto AuxiliarDB para obtener una referencia a la base de datos
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Obtener una referencia de lectura a la base de datos
        db = auxiliarDB.getReadableDatabase();

        // Llamar al método para realizar la consulta y mostrar los resultados
        consultarN();
    }

    private void consultarN(){
        //METODO PARAMETRIZADO

        // Método para recuperar todos los registros de la tabla 'usuarios' y mostrarlos en un TextView
        String listaUsuarios="";
        String[] datosARecuperar = {"codigo", "nombre"};
        Cursor cursorNParametrizado = db.query("usuarios", datosARecuperar, null, null, null, null, null);

        if (cursorNParametrizado.moveToFirst()) {
            // Recorrer el cursor y construir la lista de usuarios
            do {
                int codigo = cursorNParametrizado.getInt(0);
                String nombre = cursorNParametrizado.getString(1);
                listaUsuarios+=codigo+"-"+nombre+"\n";
            }
            while(cursorNParametrizado.moveToNext());

            // Mostrar la lista de usuarios en el TextView
            tvListaUsuarios.setText(listaUsuarios);
        }
        else {
            // Mostrar un mensaje si no se encontraron datos
            Toast.makeText(ConsultarN.this, "Datos inexistentes\nConsulta errónea", Toast.LENGTH_SHORT).show();
        }
        // Cerrar el cursor después de su uso
        cursorNParametrizado.close();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Manejar el evento de clic del botón 'btnFinConsultarN'
            switch (v.getId()) {
                case R.id.btnFinConsultarN:
                    // Cerrar la conexión con la base de datos y finalizar la actividad
                    db.close();
                    finish();
                    break;
            }
        }
    };
}
