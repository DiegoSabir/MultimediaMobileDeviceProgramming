package com.example.bdejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciar objeto de la clase auxiliar
        AuxiliarDB auxiliarDB = new AuxiliarDB(this, "BDUsuarios", null, 1);

        //invocar el metodo de apertura correspondiente: getReadebleDatabase() y getWritableDatabase();
        db = auxiliarDB.getWritableDatabase();
    }

    public void onClickBtn(View view){
        switch (view.getId()){
            case R.id.btnInsertar:
                //codigo SQL directo
                try{
                    db.execSQL("INSERT INTO usuarios (codigo, nombre) VALUES (2, 'Diego Ribas')");
                }
                catch(SQLException e){
                    Toast.makeText(this, "Insercion erronea directa", Toast.LENGTH_SHORT).show();
                }

                //metodo especifico parametrizado
                ContentValues registroNuevo = new ContentValues();
                registroNuevo.put("codigo", 3);
                registroNuevo.put("nombre", "Leonice Ribas");
                long l = db.insert("usuarios", null, registroNuevo);
                if (l == -1){
                    Toast.makeText(this, "Insecion erronea parametrizada", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btneEliminar:
                //codigo SQL directo
                try{
                    db.execSQL("DELETE FROM usuarios WHERE codigo = 3");
                }
                catch(SQLException e){
                    Toast.makeText(this, "Eliminacion erronea directa", Toast.LENGTH_SHORT).show();
                }

                //metodo especifico parametrizado
                int i = db.delete("usuarios", "codigo = 2", null);
                if (i == 0){
                    Toast.makeText(this, "Eliminacion erronea parametrizada", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnActualizar:
                //codigo SQL directo
                try{
                    db.execSQL("UPDATE usuarios SET nombre='Z_Z' WHERE codigo = 1");
                }
                catch(SQLException e){
                    Toast.makeText(this, "Modificacion erronea directa", Toast.LENGTH_SHORT).show();
                }

                //metodo especifico parametrizado
                ContentValues registroAModificar = new ContentValues();
                registroAModificar.put("nombre", "A_A");
                db.update("usuarios", registroAModificar, "codigo=1", null);
                break;

            case R.id.btnConsulta1:
                //todo
                break;

            case R.id.btnConsulta2:
                //todo
                break;
        }
    }
}