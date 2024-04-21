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

public class MainActivity extends MenuActivity {
    LinearLayout llBackground;
    private TextView tvBievenido, tvJugamos;
    private static final int REQUEST_CODE = 1;

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
                llBackground.setBackgroundResource(R.drawable.cuatro_colores);
                return true;

            case R.id.ctx_bienvenido_opc2:
                llBackground.setBackgroundResource(R.drawable.seis_colores);
                return true;

            case R.id.ctx_bienvenido_opc3:
                llBackground.setBackgroundResource(R.drawable.nueve_colores);
                return true;

            case R.id.ctx_jugamos_opc1:
                llBackground.setBackgroundColor(getResources().getColor(R.color.white));
                return true;

            case R.id.ctx_jugamos_opc2:
                llBackground.setBackgroundColor(getResources().getColor(R.color.black));
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == 4) {
                boolean resultOk = data.getBooleanExtra("salida", false);
                if (resultOk) {
                    finish();
                }
            }
        }
    }

}