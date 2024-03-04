package com.example.bdoperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnInsertar, btnBorrar, btnModificar, btnConsultar1, btnConsultarN, btnConsultarNListView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciar objeto de la clase AuxiliarDB
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);


        findYListener();
    }

    private void findYListener() {
        //findView
        btnInsertar=findViewById(R.id.btnInsertar);
        btnBorrar=findViewById(R.id.btnBorrar);
        btnModificar=findViewById(R.id.btnModificar);
        btnConsultar1=findViewById(R.id.btnConsultar1);
        btnConsultarN=findViewById(R.id.btnConsultarN);
        btnConsultarNListView=findViewById(R.id.btnConsultarNListView);

        //setListeners
        btnInsertar.setOnClickListener(clickListener);
        btnBorrar.setOnClickListener(clickListener);
        btnModificar.setOnClickListener(clickListener);
        btnConsultar1.setOnClickListener(clickListener);
        btnConsultarN.setOnClickListener(clickListener);
        btnConsultarNListView.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnInsertar:
                    //llamar Activity Insertar
                    intent = new Intent(MainActivity.this, ActivityInsertar.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
                case R.id.btnBorrar:
                    //llamar Activity Borrar
                    intent = new Intent(MainActivity.this, ActivityBorrar.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
                case R.id.btnModificar:
                    //llamar Activity Modificar
                    intent = new Intent(MainActivity.this, ActivityModificar.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
                case R.id.btnConsultar1:
                    //llamar Activity Consultar1
                    intent = new Intent(MainActivity.this, ActivityConsultar1.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
                case R.id.btnConsultarN:
                    //llamar Activity ConsultarN
                    intent = new Intent(MainActivity.this, ActivityConsultarN.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
                case R.id.btnConsultarNListView:
                    //llamar Activity ConsultarN
                    intent = new Intent(MainActivity.this, ActivityConsultarNListView.class);
                    //realizar la llamada
                    startActivity(intent);
                    break;
            }
        }
    };
}