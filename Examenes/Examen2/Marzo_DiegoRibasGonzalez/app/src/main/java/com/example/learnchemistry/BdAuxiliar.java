package com.example.learnchemistry;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class BdAuxiliar extends SQLiteOpenHelper implements Serializable {

    private String sqlCreate = "CREATE TABLE quimicos (formula TEXT PRIMARY KEY, nombre TEXT)";
    private String strInsertAdmin = "INSERT INTO quimicos (formula, nombre) VALUES ('SO4H2','Acido sulfurico'), ('H20','Agua'), ('CO3CA','Carbonato calcico'), ('C02','Anhidrido carbonico'), ('C0','Monoxido de carbono')";
    private Context context;

    public BdAuxiliar(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Sentencia para la creacion de una tabla en la BD
        db.execSQL(sqlCreate);

        try {
            // Sentencia para la insercion de datos en una tabla en la BD
            db.execSQL(strInsertAdmin);
        }
        catch (SQLException e){
            Toast.makeText(context, "Error de Inserción", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}