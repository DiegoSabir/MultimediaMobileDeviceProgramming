package com.example.e02_preferenciascompartida_v2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View view_color;
    private String[] arrayColores;
    private String color;
    private SharedPreferences preferencia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_color = findViewById(R.id.view_color);
        arrayColores = getResources().getStringArray(R.array.colores);
        preferencia = PreferenceManager.getDefaultSharedPreferences(this);

        colorear();
    }

    public void onClickBtn(View view) {
        switch (view.getId()){

            case

            /*
            case R.id.btnIniciar:
                dialogo_lista_simpleChoice();
                break;


            case R.id.btnResetear:
                SharedPreferences.Editor editorPreferencia = preferencia.edit();
                editorPreferencia.clear();
                editorPreferencia.apply();
                colorear();
                break;

                 */
        }
    }

    private void dialogo_lista_simpleChoice() {
        color = "Ningún color seleccionado";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Atención!");
        builder.setSingleChoiceItems(arrayColores, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color = arrayColores[which];
            }
        });


        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editorPreferencia = preferencia.edit();
                editorPreferencia.putString("color", color);
                editorPreferencia.apply();
                colorear();
            }
        });
        builder.show();
    }


    private void colorear() {
        color = preferencia.getString("color", "Negro");

        switch (color) {
            case "Rojo":
                view_color.setBackgroundColor(getColor(R.color.red));
                break;

            case "Azul":
                view_color.setBackgroundColor(getColor(R.color.blue));
                break;

            case "Verde":
                view_color.setBackgroundColor(getColor(R.color.green));
                break;

            case "Amarillo":
                view_color.setBackgroundColor(getColor(R.color.yellow));
                break;

            default:
                view_color.setBackgroundColor(getColor(R.color.black));
                break;
        }
        Toast.makeText(this,color, Toast.LENGTH_SHORT).show();
    }
}