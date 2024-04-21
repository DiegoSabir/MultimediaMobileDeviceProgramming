package com.example.ejercicio5_dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llBtnPantallas;
    private Button btnPantalla1, btnPantalla2, btnPantalla3, btnPantalla4;
    private static final int REQUEST_CODE = 1;
    int mensageDialog = 0;
    int tituloDialog = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBtnPantallas = findViewById(R.id.llBtnPantallas);

        btnPantalla1 = findViewById(R.id.btnPantalla1);
        btnPantalla2 = findViewById(R.id.btnPantalla2);
        btnPantalla3 = findViewById(R.id.btnPantalla3);
        btnPantalla4 = findViewById(R.id.btnPantalla4);

        btnPantalla1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mensageDialog = R.string.DialogBtnPantalla1;
                tituloDialog = R.string.DialogTitleBtnPantalla1;
                mostrarDialog(mensageDialog, tituloDialog);
                return false;
            }
        });

        btnPantalla2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mensageDialog = R.string.DialogBtnPantalla2;
                tituloDialog = R.string.DialogTitleBtnPantalla2;
                mostrarDialog(mensageDialog, tituloDialog);
                return false;
            }
        });

        btnPantalla3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mensageDialog = R.string.DialogBtnPantalla3;
                tituloDialog = R.string.DialogTitleBtnPantalla3;
                mostrarDialog(mensageDialog, tituloDialog);
                return false;
            }
        });

        btnPantalla4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mensageDialog = R.string.DialogBtnPantalla4;
                tituloDialog = R.string.DialogTitleBtnPantalla4;
                mostrarDialog(mensageDialog, tituloDialog);
                return false;
            }
        });
    }

    public void onClickBtn(View view){
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnPantalla1:
                intent = new Intent(MainActivity.this, Pantalla1.class);
                break;

            case R.id.btnPantalla2:
                intent = new Intent(MainActivity.this, Pantalla2.class);
                break;

            case R.id.btnPantalla3:
                intent = new Intent(MainActivity.this, Pantalla3.class);
                break;

            case R.id.btnPantalla4:
                intent = new Intent(MainActivity.this, Pantalla4.class);
                break;
        }
        startActivityForResult(intent, REQUEST_CODE);
    }

    private void mostrarDialog(int mensageDialog, int tituloDialog) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.colors_icon)
                .setMessage(mensageDialog)
                .setTitle(tituloDialog)
                .show();
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