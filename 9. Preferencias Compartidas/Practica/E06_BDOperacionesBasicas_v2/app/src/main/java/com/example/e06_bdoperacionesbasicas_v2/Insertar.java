package com.example.e06_bdoperacionesbasicas_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insertar extends AppCompatActivity {
    /*
    Se declaran variables para:
    - Los botones (btnInsertarUsuario, btnFinInsertar)
    - Los campos de texto (etCodigoInsert, etNombreInsert) de la interfaz de usuario
    - Así como para la base de datos SQLite (db).
     */
    private Button btnInsertarUsuario, btnFinInsertar;
    private EditText etCodigoInsert, etNombreInsert;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        // Buscar referencias de los elementos de la interfaz de usuario
        btnInsertarUsuario = findViewById(R.id.btnInsertarUsuario);
        btnFinInsertar = findViewById(R.id.btnFinInsertar);
        etCodigoInsert = findViewById(R.id.etCodigoInsert);
        etNombreInsert = findViewById(R.id.etNombreInsert);

        // Establecer listeners para los botones
        btnInsertarUsuario.setOnClickListener(clickListener);
        btnFinInsertar.setOnClickListener(clickListener);

        // Instanciar un objeto AuxiliarDB para obtener una referencia a la base de datos
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Obtener una referencia de escritura a la base de datos
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnInsertarUsuario:
                    // Obtener los valores de los campos de texto
                    String codigo = etCodigoInsert.getText().toString();
                    String nombre = etNombreInsert.getText().toString();

                    // Verificar si los campos están vacíos
                    if (codigo.isEmpty() || nombre.isEmpty()) {
                        Toast.makeText(Insertar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //METODO ESPECIFICO PARAMETRIZADO
                        // Crear un registro nuevo con los valores proporcionados
                        ContentValues registroNuevo = new ContentValues();
                        registroNuevo.put("codigo", codigo);
                        registroNuevo.put("nombre", nombre);

                        // Insertar el registro en la base de datos
                        long l = db.insert("usuarios", null, registroNuevo);

                        // Verificar si la inserción fue exitosa
                        if (l == -1) {
                            Toast.makeText(Insertar.this, "Inserción errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Insertar.this, "Insertado correctamente", Toast.LENGTH_SHORT).show();
                            // Limpiar los campos de texto después de la inserción exitosa
                            etCodigoInsert.setText("");
                            etNombreInsert.setText("");
                        }
                    }
                    break;

                case R.id.btnFinInsertar:
                    // Cerrar la conexión con la base de datos y finalizar la actividad
                    db.close();
                    finish();
                    break;
            }
        }
    };
}
