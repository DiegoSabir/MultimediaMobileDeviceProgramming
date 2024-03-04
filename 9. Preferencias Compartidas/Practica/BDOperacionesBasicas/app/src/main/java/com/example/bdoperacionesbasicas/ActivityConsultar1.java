package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityConsultar1 extends AppCompatActivity {
    private Button btnConsultar1Usuario, btnFinConsultar1;
    private EditText etCodigoConsultar1;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar1);

        btnConsultar1Usuario =findViewById(R.id.btnConsultar1Usuario);
        btnFinConsultar1 =findViewById(R.id.btnFinConsultar1);
        etCodigoConsultar1 =findViewById(R.id.etCodigoConsultar1);

        btnConsultar1Usuario.setOnClickListener(clickListener);
        btnFinConsultar1.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getReadableDatabase();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnConsultar1Usuario:
                    String codigo = etCodigoConsultar1.getText().toString();

                    if (codigo.isEmpty()) {
                        Toast.makeText(ActivityConsultar1.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        //metodo específico parametrizado
                        String[] datoARecuperar = {"nombre"};
                        Cursor cursorParametrizado = db.query("usuarios", datoARecuperar, "codigo="+codigo, null, null, null, null);
                        if (cursorParametrizado.moveToFirst()) {
                            String nombre = cursorParametrizado.getString(0);
                            Toast.makeText(ActivityConsultar1.this, "Nombre: "+nombre, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ActivityConsultar1.this, "Dato inexistente\nConsulta errónea", Toast.LENGTH_SHORT).show();
                        }
                        cursorParametrizado.close();
                    }
                    break;
                case R.id.btnFinConsultar1:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}