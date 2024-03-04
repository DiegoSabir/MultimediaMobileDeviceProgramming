package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityBorrar extends AppCompatActivity {
    private Button btnBorrarUsuario, btnFinBorrar;
    private EditText etCodigoBorrar;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);

        btnBorrarUsuario=findViewById(R.id.btnBorrarUsuario);
        btnFinBorrar=findViewById(R.id.btnFinBorrar);
        etCodigoBorrar=findViewById(R.id.etCodigoBorrar);

        btnBorrarUsuario.setOnClickListener(clickListener);
        btnFinBorrar.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getWritableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnBorrarUsuario:
                    String codigo = etCodigoBorrar.getText().toString();

                    if (codigo.isEmpty()) {
                        Toast.makeText(ActivityBorrar.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //metodo específico parametrizado
                        int i = db.delete("usuarios", "codigo="+codigo, null);
                        if (i==0){
                            Toast.makeText(ActivityBorrar.this, "Eliminación errónea", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(ActivityBorrar.this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                            etCodigoBorrar.setText("");
                        }
                    }
                    break;
                case R.id.btnFinBorrar:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}