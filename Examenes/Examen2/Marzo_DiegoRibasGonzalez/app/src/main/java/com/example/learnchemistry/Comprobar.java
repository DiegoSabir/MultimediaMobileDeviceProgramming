package com.example.learnchemistry;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Comprobar extends AppCompatActivity {
    private LinearLayout llComprobacion, llResultadoComprobacion;
    private Button btnComprobar, btnContinuar;
    private RadioGroup rgOpciones;
    private EditText etFormula;
    private SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobar);

        llComprobacion = findViewById(R.id.llComprobacion);
        llResultadoComprobacion = findViewById(R.id.llResultadoComprobacion);
        etFormula = findViewById(R.id.etFormula);
        btnComprobar = findViewById(R.id.btnComprobar);
        btnContinuar = findViewById(R.id.btnContinuar);
        rgOpciones = findViewById(R.id.rgOpciones);

        btnComprobar.setOnClickListener(escuchadorComprobar);
        btnContinuar.setOnClickListener(escuchadorContinuar);

        BdAuxiliar bdAuxiliar = new BdAuxiliar(this, "BDUsuarios", null, 1);
        db= bdAuxiliar.getReadableDatabase();
        //rgOpciones.setOnCheckedChangeListener(escuchadorOpciones);
    }

    private View.OnClickListener escuchadorComprobar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Obtener el código ingresado por el usuario
            String formula = etFormula.getText().toString();

            // Verificar si el campo está vacío
            if (formula.isEmpty()) {
                Toast.makeText(Comprobar.this, "Introduzca una formula", Toast.LENGTH_SHORT).show();
            }
            else {
                //METODO ESPECIFICO PARAMETRIZADO

                // Definir las columnas que se desean recuperar
                String[] datoARecuperar = {"formula"};

                // Realizar la consulta a la base de datos
                Cursor cursorParametrizado = db.query("quimicos", datoARecuperar, "formula="+formula, null, null, null, null);

                // Verificar si se encontró algún resultado
                if (cursorParametrizado.moveToFirst()) {
                    // Recuperar el valor del campo 'nombre'
                    String nombre = cursorParametrizado.getString(0);

                    // Mostrar el nombre recuperado en un mensaje Toast
                    Toast.makeText(Comprobar.this, "Correcto", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Mostrar un mensaje indicando que no se encontró el dato
                    Toast.makeText(Comprobar.this, "Incorrecto", Toast.LENGTH_SHORT).show();
                }
                // Cerrar el cursor después de su uso
                cursorParametrizado.close();
            }

            llComprobacion.setVisibility(View.GONE);
            llResultadoComprobacion.setVisibility(View.VISIBLE);
        }
    };


    private View.OnClickListener escuchadorContinuar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Comprobar.this, MainActivity.class);
        }
    };
}
