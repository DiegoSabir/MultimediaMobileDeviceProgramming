package com.example.saludarjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText textoNombre, textoNacimiento;
    private RadioButton radioHombre, radioMujer, radioAdios, radioHastaPronto;
    private CheckBox checkDespedida;

    private TextView textoSaludo,despedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNombre = findViewById(R.id.nombre);
        textoNacimiento = findViewById(R.id.año);

        radioHombre = findViewById(R.id.hombre);
        radioMujer = findViewById(R.id.mujer);
        radioAdios = findViewById(R.id.adios);
        radioHastaPronto = findViewById(R.id.hastapronto);

        checkDespedida = findViewById(R.id.despedida);
        despedida = findViewById(R.id.elegir);

        textoSaludo = findViewById(R.id.cambios);

        listeners();
    }

    private void listeners(){
        checkDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    despedida.setVisibility(View.VISIBLE);
                    radioAdios.setVisibility(View.VISIBLE);
                    radioHastaPronto.setVisibility(View.VISIBLE);
                } else{
                    despedida.setVisibility(View.GONE);
                    radioAdios.setVisibility(View.GONE);
                    radioHastaPronto.setVisibility(View.GONE);

                }
            }
        });
    }

    private boolean comprobarDatos(){
        if(textoNombre.getText().toString().isEmpty() || textoNacimiento.getText().toString().isEmpty()){
            Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void saludar(View v){
        if(comprobarDatos()){
            String saludo = "Hola, ";
            if (radioMujer.isChecked()){
                saludo += "Sra. ";
            } else{
                saludo += "Sr. ";
            }
            saludo += textoNombre.getText().toString()+"\n";

            if (Integer.parseInt(textoNacimiento.getText().toString()) < 2005){
                saludo += "Eres mayor de edad";
            } else{
                saludo += "Eres menor de edad";
            }

            if (checkDespedida.isChecked()){
                if (radioAdios.isChecked()){
                    saludo += "\nAdios";
                } else{
                    saludo += "\nHasta pronto";
                }
            }
            textoSaludo.setText(saludo);
        }

    }

}
