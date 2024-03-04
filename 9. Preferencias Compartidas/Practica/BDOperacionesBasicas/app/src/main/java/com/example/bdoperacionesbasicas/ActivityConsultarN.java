package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityConsultarN extends AppCompatActivity {
    private Button btnFinConsultarN;
    private TextView tvListaUsuarios;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_n);

        btnFinConsultarN=findViewById(R.id.btnFinConsultarN);
        tvListaUsuarios=findViewById(R.id.tvListaUsuarios);

        btnFinConsultarN.setOnClickListener(clickListener);

        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);
        db = auxiliarDB.getReadableDatabase();

        consultarN();
    }

    private void consultarN(){
        //metodo parametrizado
        String listaUsuarios="";
        String[] datosARecuperar = {"codigo", "nombre"};
        Cursor cursorNParametrizado = db.query("usuarios", datosARecuperar, null, null, null, null, null);
        if (cursorNParametrizado.moveToFirst()) {
            do {
                int codigo = cursorNParametrizado.getInt(0);
                String nombre = cursorNParametrizado.getString(1);
                listaUsuarios+=codigo+"-"+nombre+"\n";
            }while(cursorNParametrizado.moveToNext());
            tvListaUsuarios.setText(listaUsuarios);
        } else {
            Toast.makeText(ActivityConsultarN.this, "Datos inexistentes\nConsulta errónea", Toast.LENGTH_SHORT).show();
        }
        cursorNParametrizado.close();
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnFinConsultarN:
                    db.close();
                    finish();
                    break;
            }
        }
    };
}