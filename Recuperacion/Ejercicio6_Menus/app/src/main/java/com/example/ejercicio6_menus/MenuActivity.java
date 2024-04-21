package com.example.ejercicio6_menus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {
    private static final int RESPUESTA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.opc_pantalla1:
                intent = new Intent(this, Pantalla1.class);
                startActivityForResult(intent, RESPUESTA);
                return true;

            case R.id.opc_pantalla2:
                intent = new Intent(this, Pantalla2.class);
                startActivityForResult(intent, RESPUESTA);
                return true;

            case R.id.opc_pantalla3:
                intent = new Intent(this, Pantalla3.class);
                startActivityForResult(intent, RESPUESTA);
                return true;

            case R.id.opc_pantalla4:
                intent = new Intent(this, Pantalla4.class);
                startActivityForResult(intent, RESPUESTA);
                return true;

            case R.id.opc_finalizar:
                showDialogWithOptions();
                return true;

            case R.id.opc_acercade:
                showDialog();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showDialogWithOptions() {
        new AlertDialog.Builder(this)
                .setTitle("CIERRE DE APP")
                .setMessage("¿La app se va a cerrar\n¿Está seguro?")
                .setIcon(R.drawable.cuatro_colores)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    private void showDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Acerca de")
                .setMessage("2º DAM IES Teis\nProgramacion Multimedia de Dispositivos Moviles\nRibas Gonzalez Diego")
                .setIcon(R.drawable.colors_icon)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESPUESTA) {
            if (resultCode == RESULT_OK) {
                boolean resultOk = data.getBooleanExtra("resultOk", false);
                if (resultOk) {
                    finish();
                }
            }
        }
    }
}
