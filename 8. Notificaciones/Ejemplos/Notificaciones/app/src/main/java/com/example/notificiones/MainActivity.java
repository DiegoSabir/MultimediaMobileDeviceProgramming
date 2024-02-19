package com.example.notificiones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view){
        switch (view.getId()){
            case R.id.btn_mensaje:
                dialogo_mensaje();
                break;

            case R.id.btn_1boton:
                dialogo_ventana_1boton();
                break;

            case R.id.btn_2botones:
                dialogo_ventana_2botones();
                break;

            case R.id.btn_3botones:
                dialogo_ventana_3botones();
                break;

            case R.id.btn_lista_simple:
                dialogo_lista_simple();
                break;

            case R.id.btn_lista_simple_aceptar_opc:
                dialogo_lista_simple_aceptar_opc();
                break;
        }
    }

    private void dialogo_lista_simple_aceptar_opc() {
    }


    private void dialogo_mensaje(){
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso);
        ventana.setTitle("ATENCION!");
        ventana.setMessage("Esto es un mensaje de aviso bla bla bla");
        ventana.show();
    }

    private void dialogo_ventana_1boton() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso)
                .setTitle("ATENCION!")
                .setMessage("Esto es un mensaje de aviso bla bla bla")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // todo operaciones correspondientes
                        Toast.makeText(MainActivity.this, "Pulsado ok", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void dialogo_ventana_2botones() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso)
                .setTitle("ATENCION!")
                .setMessage("Esto es un mensaje de aviso bla bla bla")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // todo operaciones correspondientes
                        Toast.makeText(MainActivity.this, "Pulsado ok", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo operaciones correspondientes
                        Toast.makeText(MainActivity.this, "Pulsado cancel", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void dialogo_ventana_3botones() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso)
                .setTitle("ATENCION!")
                .setMessage("Esto es un mensaje de aviso bla bla bla")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        // todo operaciones correspondientes
                        Toast.makeText(MainActivity.this, "Pulsado ok", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //todo operaciones correspondientes
                        Toast.makeText(MainActivity.this, "Pulsado cancel", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void dialogo_lista_simple() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso);
        ventana.setTitle("ATENCION!");
        ventana.setItems(R.array.colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Pulsado " + getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();
            }
        });
        ventana.show();
    }

}