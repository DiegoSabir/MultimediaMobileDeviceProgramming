package com.example.e06_bdoperacionesbasicas_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar extends AppCompatActivity {
    /*
    Se declaran variables para:
     - Los botones (btnModificarUsuario, btnFinModificar)
     - Los campos de texto (etCodigoModificar, etNombreModificar) de la interfaz de usuario
     - Así como para la base de datos SQLite (db).
     */
    private Button btnModificarUsuario, btnFinModificar;
    private EditText etCodigoModificar, etNombreModificar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        // Buscar referencias de los elementos de la interfaz de usuario
        btnModificarUsuario=findViewById(R.id.btnModificarUsuario);
        btnFinModificar=findViewById(R.id.btnFinModificar);
        etCodigoModificar=findViewById(R.id.etCodigoModificar);
        etNombreModificar=findViewById(R.id.etNombreModificar);

        // Establecer listeners para los botones
        btnModificarUsuario.setOnClickListener(clickListener);
        btnFinModificar.setOnClickListener(clickListener);

        // Instanciar un objeto AuxiliarDB para obtener una referencia a la base de datos
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Obtener una referencia de escritura a la base de datos
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnModificarUsuario:
                    // Obtener los valores de los campos de texto
                    String codigo = etCodigoModificar.getText().toString();
                    String nombre = etNombreModificar.getText().toString();

                    // Verificar si los campos están vacíos
                    if (codigo.isEmpty() || nombre.isEmpty()) {
                        Toast.makeText(Modificar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //METODO ESPECIFICO PARAMETRIZADO

                        // Crear un ContentValues con los nuevos valores
                        ContentValues registroAModificar = new ContentValues();
                        registroAModificar.put("nombre", nombre);

                        // Actualizar el registro correspondiente al código proporcionado
                        int i = db.update("usuarios", registroAModificar, "codigo="+codigo, null);

                        // Verificar si se modificó algún registro
                        if (i==0){
                            Toast.makeText(Modificar.this, "Modificación errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Modificar.this, "Modificado correctamente", Toast.LENGTH_SHORT).show();

                            // Limpiar los campos de texto después de la modificación
                            etCodigoModificar.setText("");
                            etNombreModificar.setText("");
                        }
                    }
                    break;

                case R.id.btnFinModificar:
                    // Cerrar la conexión con la base de datos y finalizar la actividad
                    db.close();
                    finish();
                    break;
            }
        }
    };
}
