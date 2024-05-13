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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        btnConsultar = findViewById(R.id.btnConsultar);
        tvEmail = findViewById(R.id.tvEmail);

        // Copiar la base de datos desde assets a la ubicación de la aplicación si no existe
        String dbPath = getDatabasePath("bbdd.db").getPath();
        if (!checkDatabaseExists(dbPath)) {
            copyDatabaseFromAssets();
        }

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarEmail();
            }
        });
    }

    private boolean checkDatabaseExists(String dbPath) {
        File dbFile = new File(dbPath);
        return dbFile.exists();
    }

    private void copyDatabaseFromAssets() {
        try {
            InputStream myInput = getAssets().open("bbdd.db");
            String outputFileName = getDatabasePath("bbdd.db").getPath();
            OutputStream myOutput = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buscarEmail() {
        String nombre = etNombre.getText().toString().trim();

        // Crear una instancia de DatabaseHelper
        DataBaseHelper dbHelper = new DataBaseHelper(this);

        // Obtener una instancia de la base de datos en modo lectura
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Realizar la consulta
        Cursor cursor = db.rawQuery("SELECT email FROM alumnos WHERE nombre=?", new String[]{nombre});

        // Verificar si se encontraron resultados
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("email");
            if (columnIndex != -1) {
                String email = cursor.getString(columnIndex);
                tvEmail.setText(email);
            }
            else {
                tvEmail.setText("Columna 'email' no encontrada en el resultado de la consulta.");
            }
        }
        else {
            tvEmail.setText("Email no encontrado para este nombre.");
        }

        // Cerrar el cursor y la base de datos
        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }


}
