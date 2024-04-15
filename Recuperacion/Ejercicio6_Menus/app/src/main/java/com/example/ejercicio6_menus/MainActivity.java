package com.example.ejercicio6_menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvBievenido, tvJugamos;
    LinearLayout llBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBievenido = findViewById(R.id.tvBienvenido);
        tvJugamos = findViewById(R.id.tvJugamos);

        registerForContextMenu(tvBievenido);
        registerForContextMenu(tvJugamos);

        llBackground = findViewById(R.id.llBackground);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.tvBienvenido) {
            getMenuInflater().inflate(R.menu.menu_contextual_bievenido, menu);
        }
        else if (v.getId() == R.id.tvJugamos) {
            getMenuInflater().inflate(R.menu.menu_contextual_jugamos, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ctx_bienvenido_opc1:
                llBackground.setBackgroundResource(R.drawable.colores);
                return true;

            case R.id.ctx_bienvenido_opc2:
                llBackground.setBackgroundResource(R.drawable.coloresdos);
                return true;

            case R.id.ctx_bienvenido_opc3:
                llBackground.setBackgroundResource(R.drawable.colorestres);
                return true;

            case R.id.ctx_jugamos_opc1:
                llBackground.setBackgroundColor(getResources().getColor(R.color.white));
                return true;

            case R.id.ctx_jugamos_opc2:
                llBackground.setBackgroundColor(getResources().getColor(R.color.black));
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
            case R.id.opc_pantalla1:
                intent = new Intent(this, Pantalla1.class);
                startActivity(intent);
                return true;

            case R.id.opc_pantalla2:
                intent = new Intent(this, Pantalla2.class);
                startActivity(intent);
                return true;

            case R.id.opc_pantalla3:
                intent = new Intent(this, Pantalla3.class);
                startActivity(intent);
                return true;

            case R.id.opc_pantalla4:
                intent = new Intent(this, Pantalla4.class);
                startActivity(intent);
                return true;

            case R.id.opc_finalizar:
                showDialogWithOptions();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void showDialogWithOptions() {
        new AlertDialog.Builder(this)
                .setTitle("CIERRE DE APP")
                .setMessage("¿La app se va a cerrar\n¿Está seguro?")
                .setIcon(R.drawable.colores)
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
}