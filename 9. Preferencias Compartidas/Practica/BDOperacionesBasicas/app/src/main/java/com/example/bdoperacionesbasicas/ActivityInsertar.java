package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInsertar extends AppCompatActivity {
    private Button btnInsertarUsuario, btnFinInsertar;
    private EditText etCodigoInsert, etNombreInsert;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        btnInsertarUsuario=findViewById(R.id.btnInsertarUsuario);
        btnFinInsertar=findViewById(R.id.btnFinInsertar);
        etCodigoInsert=findViewById(R.id.etCodigoInsert);
        etNombreInsert=findViewById(R.id.etNombreInsert);

        btnInsertarUsuario.setOnClickListener(clickListener);
        btnFinInsertar.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnInsertarUsuario:
                    String codigo = etCodigoInsert.getText().toString();
                    String nombre = etNombreInsert.getText().toString();

                    if (codigo.isEmpty() || nombre.isEmpty()) {
                        Toast.makeText(ActivityInsertar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //metodo específico parametrizado
                        ContentValues registroNuevo = new ContentValues();
                        registroNuevo.put("codigo", codigo);
                        registroNuevo.put("nombre", nombre);
                        long l = db.insert("usuarios", null, registroNuevo);
                        if (l == -1) {
                            Toast.makeText(ActivityInsertar.this, "Inserción errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ActivityInsertar.this, "Insertado correctamente", Toast.LENGTH_SHORT).show();
                            etCodigoInsert.setText("");
                            etNombreInsert.setText("");
                        }
                    }
                    break;
                case R.id.btnFinInsertar:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}