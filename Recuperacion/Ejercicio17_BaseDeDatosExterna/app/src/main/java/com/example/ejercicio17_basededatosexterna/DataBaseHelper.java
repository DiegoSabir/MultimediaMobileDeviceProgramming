package com.example.ejercicio17_basededatosexterna;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;


public class DataBaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "bbdd.db";
    private static final int DATABASE_VERSION = 1;
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_EMAIL = "email";
    private final Context context;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public String buscarEmailPorNombre(String nombre) {
        SQLiteDatabase db = getReadableDatabase();
        String email = null;

        Cursor cursor = db.rawQuery("SELECT email FROM alumnos WHERE nombre=?", new String[]{nombre});

        if (cursor.moveToFirst()) {
            email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
        }

        cursor.close();
        db.close();

        return email;
    }
}
