package com.example.e6_menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView bienvenido, jugar;
    LinearLayout fondoimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bienvenido = findViewById(R.id.bienvenido);
        jugar = findViewById(R.id.jugar);
        registerForContextMenu(bienvenido);
        registerForContextMenu(jugar);
        fondoimagen = findViewById(R.id.fondoimagen);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            super.onCreateContextMenu(menu, v, menuInfo);
            if (v.getId() == R.id.bienvenido) {
                getMenuInflater().inflate(R.menu.menu_contextual, menu);
            } else if (v.getId() == R.id.jugar) {
                getMenuInflater().inflate(R.menu.menu_contextual2, menu);
            }
        }

        @Override
        public boolean onContextItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.colores4:
                    fondoimagen.setBackgroundResource(R.drawable.colores);
                    return true;
                case R.id.colores6:
                    fondoimagen.setBackgroundResource(R.drawable.coloresdos);
                    return true;
                case R.id.colores9:
                    fondoimagen.setBackgroundResource(R.drawable.colorestres);
                    return true;
                case R.id.eliminar:
                    fondoimagen.setBackgroundColor(getResources().getColor(R.color.white));
                    return true;
                case R.id.negro:
                    fondoimagen.setBackgroundColor(getResources().getColor(R.color.black));
                    return true;
                default:
                    return super.onContextItemSelected(item);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.pantalla1:
                intent = new Intent(this, Pantalla1.class);
                startActivity(intent);
                return true;

            case R.id.pantalla2:
                intent = new Intent(this, Pantalla2.class);
                startActivity(intent);
                return true;

            case R.id.pantalla3:
                intent = new Intent(this, Pantalla3.class);
                startActivity(intent);
                return true;

            case R.id.pantalla4:
                intent = new Intent(this, Pantalla4.class);
                startActivity(intent);
                return true;

            case R.id.fin:
                showDialogWithOptions();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void showDialogWithOptions() {
        new AlertDialog.Builder(this)
                .setTitle("Fuera")
                .setMessage("¿Estás seguro de que deseas salir de la aplicación?")
                .setIcon(R.drawable.colores)
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
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

}