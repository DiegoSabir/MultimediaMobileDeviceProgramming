package com.example.notificiones;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int posicion;
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

            case R.id.btn_lista_single_choice:
                dialogo_lista_single_choice();
                break;

            case R.id.btn_lista_multiple_choice:
                dialogo_lista_multiple_choice();
                break;
        }
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
                        //Toast.makeText(MainActivity.this, "Pulsado cancel", Toast.LENGTH_SHORT).show();

                        Toast t = Toast.makeText(MainActivity.this, "Pulsado Cancel", Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.TOP | Gravity.END,0,0);
                        t.show();

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

    private void dialogo_lista_simple_aceptar_opc() {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso);
        ventana.setTitle("Lista de colores!");
        ventana.setItems(R.array.colores, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Pulsado " + getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();
            }
        });
        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Has finalizado tu eleccion: ", Toast.LENGTH_SHORT).show();
            }
        });
        ventana.show();
    }

    private void dialogo_lista_single_choice() {
        //posicion = 0;
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso);
        ventana.setTitle("Lista de colores!");
        ventana.setSingleChoiceItems(R.array.colores, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Pulsado " + getResources().getStringArray(R.array.colores)[which], Toast.LENGTH_SHORT).show();
                posicion = which;
                //dialog.cancel();
            }
        });
        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //todo operaciones relacionadas con la opcion -color- seleccionada
                Toast.makeText(MainActivity.this, "Eleccion final: " + getResources().getStringArray(R.array.colores)[posicion], Toast.LENGTH_SHORT).show();
            }
        });
        ventana.show();
    }

    private void dialogo_lista_multiple_choice() {
        boolean[] coloresSeleccionados = {false, false, false, false};
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setIcon(R.drawable.aviso);
        ventana.setTitle("Lista de colores!");
        ventana.setMultiChoiceItems(R.array.colores, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    //si color en posicion which esta seleccionado --> true la posicion correspondiente a ese color
                    coloresSeleccionados[which]=true;
                }
                else{
                    coloresSeleccionados[which]=true;
                }
            }
        });
        ventana.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //recorrer el array booleano con la indicacion de los colores seleccionados
                String strSelecionados="";
                for (int j = 0; j < coloresSeleccionados.length; j++){
                    if(coloresSeleccionados[j]){
                        strSelecionados += getResources().getStringArray(R.array.colores[j] + "\n");
                    }
                }
                //todo operaciones relacionadas con la opcion -color- seleccionada
                Toast.makeText(MainActivity.this, strSelecionados, Toast.LENGTH_SHORT).show();
            }
        });
        ventana.show();

        private void toast_personalizada(){
            LinearLayout llToast = findViewById(R.id.ll_toast);
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.toast_personalizada, llToast);
            TextView textoDeToast = view.findViewById(R.id.txt_mensaje_toast);
            textoDeToast.setText("Pulsado Ok");

            Toast toast = new Toast(this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(view);
            toast.show();
        }
    }
}