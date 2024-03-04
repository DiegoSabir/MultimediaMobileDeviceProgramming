package com.example.e06_bdoperacionesbasicas_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Borrar extends AppCompatActivity {
    /*
    Se declaran variables para:
     - Los botones (btnBorrarUsuario, btnFinBorrar)
     - El campo de texto (etCodigoBorrar) de la interfaz de usuario
     - Así como para la base de datos SQLite (db)
     */
    private Button btnBorrarUsuario, btnFinBorrar;
    private EditText etCodigoBorrar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);

        // Buscar referencias de los elementos de la interfaz de usuario
        btnBorrarUsuario=findViewById(R.id.btnBorrarUsuario);
        btnFinBorrar=findViewById(R.id.btnFinBorrar);
        etCodigoBorrar=findViewById(R.id.etCodigoBorrar);

        // Establecer listeners para los botones
        btnBorrarUsuario.setOnClickListener(clickListener);
        btnFinBorrar.setOnClickListener(clickListener);

        // Instanciar un objeto AuxiliarDB para obtener una referencia a la base de datos
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        // Obtener una referencia de escritura a la base de datos
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnBorrarUsuario:
                    // Obtener el valor del campo de texto
                    String codigo = etCodigoBorrar.getText().toString();

                    // Verificar si el campo está vacío
                    if (codigo.isEmpty()) {
                        Toast.makeText(Borrar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //METODO ESPECIFICO PARAMETRIZADO

                        // Eliminar el registro correspondiente al código proporcionado
                        int i = db.delete("usuarios", "codigo=" + codigo, null);

                        // Verificar si se eliminó algún registro
                        if (i==0){
                            Toast.makeText(Borrar.this, "Eliminación errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(Borrar.this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();

                            // Limpiar el campo de texto después de la eliminación
                            etCodigoBorrar.setText("");
                        }
                    }
                    break;

                case R.id.btnFinBorrar:
                    // Cerrar la conexión con la base de datos y finalizar la actividad
                    db.close();
                    finish();
                    break;
            }
        }
    };
}
