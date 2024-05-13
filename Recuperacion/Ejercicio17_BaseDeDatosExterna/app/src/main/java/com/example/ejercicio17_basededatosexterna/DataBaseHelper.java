package com.example.ejercicio17_basededatosexterna;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "bbdd.db";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // No necesitamos sobrescribir onCreate() ni onUpgrade() ya que la base de datos ya está creada
    // y no necesitamos gestionar actualizaciones en este caso.

    // Método para obtener una instancia de la base de datos en modo escritura
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    // Método para obtener una instancia de la base de datos en modo lectura
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }
}
