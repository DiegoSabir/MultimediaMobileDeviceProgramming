package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityModificar extends AppCompatActivity {
    private Button btnModificarUsuario, btnFinModificar;
    private EditText etCodigoModificar, etNombreModificar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        btnModificarUsuario=findViewById(R.id.btnModificarUsuario);
        btnFinModificar=findViewById(R.id.btnFinModificar);
        etCodigoModificar=findViewById(R.id.etCodigoModificar);
        etNombreModificar=findViewById(R.id.etNombreModificar);

        btnModificarUsuario.setOnClickListener(clickListener);
        btnFinModificar.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnModificarUsuario:
                    String codigo = etCodigoModificar.getText().toString();
                    String nombre = etNombreModificar.getText().toString();

                    if (codigo.isEmpty() || nombre.isEmpty()) {
                        Toast.makeText(ActivityModificar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //metodo específico parametrizado
                        ContentValues registroAModificar = new ContentValues();
                        registroAModificar.put("nombre", nombre);
                        int i = db.update("usuarios", registroAModificar, "codigo="+codigo, null);
                        if (i==0){
                            Toast.makeText(ActivityModificar.this, "Modificación errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ActivityModificar.this, "Moificado correctamente", Toast.LENGTH_SHORT).show();
                            etCodigoModificar.setText("");
                            etNombreModificar.setText("");
                        }
                    }
                    break;
                case R.id.btnFinModificar:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}