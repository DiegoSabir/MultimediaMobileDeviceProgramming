package com.example.ejercicio6_menus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class MenuActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
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
                startActivityForResult(intent, REQUEST_CODE);
                return true;

            case R.id.opc_pantalla2:
                intent = new Intent(this, Pantalla2.class);
                startActivityForResult(intent, REQUEST_CODE);
                return true;

            case R.id.opc_pantalla3:
                intent = new Intent(this, Pantalla3.class);
                startActivityForResult(intent, REQUEST_CODE);
                return true;

            case R.id.opc_pantalla4:
                intent = new Intent(this, Pantalla4.class);
                startActivityForResult(intent, REQUEST_CODE);
                return true;

            case R.id.opc_finalizar:
                showDialogWithOptions();
                return true;

            case R.id.opc_acercade:
                showDialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialogWithOptions() {
        new AlertDialog.Builder(this)
                .setTitle("CIERRE DE APP!")
                .setMessage("La app se va a cerrar\nEsta seguro?")
                .setIcon(R.drawable.colors_icon)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("salida", true);
                        setResult(4, returnIntent);
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
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
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                boolean resultOk = data.getBooleanExtra("resultOk", false);
                if (resultOk) {
                    finish();
                }
            }
        }
    }
}
