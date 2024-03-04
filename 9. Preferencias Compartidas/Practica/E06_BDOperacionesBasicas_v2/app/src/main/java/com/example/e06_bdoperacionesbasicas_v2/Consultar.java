package com.example.e06_bdoperacionesbasicas_v2;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Consultar extends AppCompatActivity {
    /*
    Se declaran variables para:
    - Los botones (btnConsultar1Usuario, btnFinConsultar1)
    - El campo de texto (etCodigoConsultar1) de la interfaz de usuario
    - Así como para la base de datos SQLite (db).
     */
    private Button btnConsultar1Usuario, btnFinConsultar1;
    private EditText etCodigoConsultar1;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar1);

        // Buscar referencias de los elementos de la interfaz de usuario
        btnConsultar1Usuario =findViewById(R.id.btnConsultar1Usuario);
        btnFinConsultar1 =findViewById(R.id.btnFinConsultar1);
        etCodigoConsultar1 =findViewById(R.id.etCodigoConsultar1);

        // Establecer listeners para los botones
        btnConsultar1Usuario.setOnClickListener(clickListener);
        btnFinConsultar1.setOnClickListener(clickListener);

        // Instanciar un objeto AuxiliarDB para obtener una referencia a la base de datos
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Obtener una referencia de lectura a la base de datos
        db = auxiliarDB.getReadableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnConsultar1Usuario:
                    // Obtener el código ingresado por el usuario
                    String codigo = etCodigoConsultar1.getText().toString();

                    // Verificar si el campo está vacío
                    if (codigo.isEmpty()) {
                        Toast.makeText(Consultar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //METODO ESPECIFICO PARAMETRIZADO

                        // Definir las columnas que se desean recuperar
                        String[] datoARecuperar = {"nombre"};

                        // Realizar la consulta a la base de datos
                        Cursor cursorParametrizado = db.query("usuarios", datoARecuperar, "codigo="+codigo, null, null, null, null);

                        // Verificar si se encontró algún resultado
                        if (cursorParametrizado.moveToFirst()) {
                            // Recuperar el valor del campo 'nombre'
                            String nombre = cursorParametrizado.getString(0);

                            // Mostrar el nombre recuperado en un mensaje Toast
                            Toast.makeText(Consultar.this, "Nombre: "+nombre, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            // Mostrar un mensaje indicando que no se encontró el dato
                            Toast.makeText(Consultar.this, "Dato inexistente\nConsulta errónea", Toast.LENGTH_SHORT).show();
                        }
                        // Cerrar el cursor después de su uso
                        cursorParametrizado.close();
                    }
                    break;

                case R.id.btnFinConsultar1:
                    // Cerrar la conexión con la base de datos y finalizar la actividad
                    db.close();
                    finish();
                    break;
            }
        }
    };
}