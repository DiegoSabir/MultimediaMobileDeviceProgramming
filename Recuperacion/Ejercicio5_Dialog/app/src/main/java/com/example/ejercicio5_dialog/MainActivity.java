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
    private static final int REQUEST_CODE = 0;

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
                dialogPantalla1();
                return false;
            }
        });

        btnPantalla2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogPantalla2();
                return false;
            }
        });

        btnPantalla3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogPantalla3();
                return false;
            }
        });

        btnPantalla4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                dialogPantalla4();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                boolean result = data.getBooleanExtra("result", false);
                if (result) {
                    finish();
                }
            }
        }
    }

    private void dialogPantalla1() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.colors_icon)
                .setMessage("Pantalla con 4 colores\nCada color lleva a una pantalla con retroceso")
                .setTitle("Pantalla 1")
                .show();
    }

    private void dialogPantalla2() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.colors_icon)
                .setMessage("Pantalla con 6 colores\nCada color lleva a una pantalla con retroceso o vuelta al inicio")
                .setTitle("Pantalla 2")
                .show();
    }

    private void dialogPantalla3() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.colors_icon)
                .setMessage("Pantalla con 6 colores y padding\nCada color lleva a una pantalla con retroceso, vuelta al inicio o fin de app")
                .setTitle("Pantalla 3")
                .show();
    }

    private void dialogPantalla4() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.colors_icon)
                .setMessage("Pantalla con 9 colores\nCada color lleva a una pantalla que permite eliminar dicho color")
                .setTitle("Pantalla 4")
                .show();
    }

}