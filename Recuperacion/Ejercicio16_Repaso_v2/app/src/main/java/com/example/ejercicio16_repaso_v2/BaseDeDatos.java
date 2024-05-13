package com.example.ejercicio16_repaso_v2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "AlumnosDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ALUMNOS = "alumnos";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_CURSO = "curso";
    private static final String COLUMN_CICLO = "ciclo";
    private static final String SQL_CREATE_ALUMNOS_TABLE =
            "CREATE TABLE " + TABLE_ALUMNOS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NOMBRE + " TEXT," +
                    COLUMN_CURSO + " TEXT," +
                    COLUMN_CICLO + " TEXT)";

    public BaseDeDatos(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ALUMNOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALUMNOS);
        onCreate(db);
    }


    public void agregarAlumno(Alumno alumno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NOMBRE, alumno.getNombre());
        values.put(COLUMN_CURSO, alumno.getCurso());
        values.put(COLUMN_CICLO, alumno.getCiclo());

        db.insert(TABLE_ALUMNOS, null, values);
        db.close();
    }

    public void borrarAlumno(Alumno alumno) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_ALUMNOS, COLUMN_ID + " = ?", new String[]{String.valueOf(alumno.getId())});
        db.close();
    }

    public List<Alumno> getAllAlumnos() {
        List<Alumno> alumnosList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ALUMNOS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Alumno alumno = new Alumno();
                alumno.setId(Integer.parseInt(cursor.getString(0)));
                alumno.setNombre(cursor.getString(1));
                alumno.setCurso(cursor.getString(2));
                alumno.setCiclo(cursor.getString(3));
                alumnosList.add(alumno);
            }
            while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return alumnosList;
    }
}
