package com.example.ejercicio17_basededatosexterna;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private Button btnConsultar;
    private TextView tvEmail;
    DataBaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnConsultar = findViewById(R.id.btnConsultar);
        tvEmail = findViewById(R.id.tvEmail);

        dbh = new DataBaseHelper(this);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString().trim();
                String email = dbh.buscarEmailPorNombre(nombre);
                if (email != null) {
                    tvEmail.setText("Email encontrado: " + email);
                }
                else {
                    tvEmail.setText("No se encontró ningún email para ese nombre.");
                }
            }
        });
    }
}
