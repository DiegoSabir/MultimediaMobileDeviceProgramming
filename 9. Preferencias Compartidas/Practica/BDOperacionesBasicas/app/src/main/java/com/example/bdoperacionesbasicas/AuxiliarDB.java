package com.example.bdoperacionesbasicas;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

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
        //sentencia de creación de la tabla/s de la BD
        db.execSQL(strCreateTable);
        //sentencias de inserción de datos iniciales
        try {
            db.execSQL(strInsertAdmin);
        } catch (SQLException e){
            Toast.makeText(context, "Error de Inserción", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //sentencias para la actualización de la BD
    }
}
