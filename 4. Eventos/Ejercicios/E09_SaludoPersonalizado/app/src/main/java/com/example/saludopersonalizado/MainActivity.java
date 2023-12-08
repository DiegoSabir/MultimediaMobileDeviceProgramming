package com.example.saludopersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etNacimiento;
    private TextView tvMensaje, tvElegir;
    private RadioButton rbMasculino, rbFemenino, rbAdios, rbHastaPronto;
    private CheckBox cbDespedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = findViewById(R.id.etNombre);
        etNacimiento = findViewById(R.id.etNacimiento);

        tvMensaje = findViewById(R.id.tvMensaje);
        tvElegir = findViewById(R.id.tvElegir);

        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbAdios = findViewById(R.id.rbAdios);
        rbHastaPronto = findViewById(R.id.rbHastaPronto);

        cbDespedida = findViewById(R.id.cbDespedida);

        listeners();
    }

    private void listeners(){
        cbDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tvElegir.setVisibility(View.VISIBLE);
                    rbAdios.setVisibility(View.VISIBLE);
                    rbHastaPronto.setVisibility(View.VISIBLE);
                }
                else{
                    tvElegir.setVisibility(View.GONE);
                    rbAdios.setVisibility(View.GONE);
                    rbHastaPronto.setVisibility(View.GONE);
                }
            }
        });
    }

    public void saludar(View v){
        if (!etNombre.getText().toString().isEmpty() || !etNacimiento.getText().toString().isEmpty()){
            String saludo = "Hola, ";

            if (rbMasculino.isChecked()){
                saludo += "Sr. ";
            }
            else{
                saludo += "Sra. ";
            }

            saludo += etNombre.getText().toString() + "\n";

            if (Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(etNacimiento.getText().toString()) >= 18) {
                saludo += "Eres mayor de edad";
            }
            else {
                saludo += "Eres menor de edad";
            }

            if (cbDespedida.isChecked()){
                if (rbAdios.isChecked()){
                    saludo += "\nAdios";
                }
                else{
                    saludo += "\nHasta pronto";
                }
            }

            tvMensaje.setText(saludo);
        }
        else {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }
    }
}