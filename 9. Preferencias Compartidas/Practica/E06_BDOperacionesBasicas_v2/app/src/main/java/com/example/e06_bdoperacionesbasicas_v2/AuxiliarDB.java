package com.example.e06_bdoperacionesbasicas_v2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

/*
Gestiona la creación y actualización de la base de datos SQLite, así como para realizar
algunas operaciones iniciales como la creación de tablas y la inserción de datos de ejemplo.
 */
public class AuxiliarDB extends SQLiteOpenHelper {
    private Context context;
    private String strCreateTable = "CREATE TABLE usuarios (codigo INT PRIMARY KEY, nombre TEXT)";
    private String strInsertAdmin = "INSERT INTO usuarios (codigo, nombre) VALUES (0, 'Admin')";

    public AuxiliarDB(@Nullable Context context,
                      @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Sentencia para la creacion de una tabla en la BD
        db.execSQL(strCreateTable);

        try {
            // Sentencia para la insercion de datos en una tabla en la BD
            db.execSQL(strInsertAdmin);
        }
        catch (SQLException e){
            Toast.makeText(context, "Error de Inserción", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //sentencias para la actualización de la BD
    }
}
