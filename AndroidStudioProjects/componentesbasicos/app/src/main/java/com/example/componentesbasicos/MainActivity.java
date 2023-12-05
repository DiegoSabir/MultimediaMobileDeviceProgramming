package com.example.componentesbasicos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ToggleButton togglebtn;
    private Switch wifi;
    private CheckBox chkacept;
    private EditText numero, nombre, decimal;
    private Button btnguardar;
    private RadioGroup radio;
    private RadioButton si, no, aveces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializar variables
        togglebtn = findViewById(R.id.toggle);
        wifi = findViewById(R.id.switchWifi);
        chkacept = findViewById(R.id.chkcondiciones);
        numero = findViewById(R.id.etnumber);
        nombre = findViewById(R.id.etnombre);
        decimal = findViewById(R.id.etdecimal);
        btnguardar = findViewById(R.id.btn_estandar);
        radio = findViewById(R.id.rg1);
        si = findViewById(R.id.radio1);
        no = findViewById(R.id.radio2);
        aveces = findViewById(R.id.radio3);

        //escuchador check
        chkacept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    Toast.makeText(MainActivity.this, "Cambio estado: Acepto", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Cambio estado: No acepto", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //escuchador radio
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.radio1){
                    Toast.makeText(MainActivity.this, "Cambio: Elegido Si", Toast.LENGTH_SHORT).show();
                }else if (i==R.id.radio2){
                    Toast.makeText(MainActivity.this, "Cambio: Elegido No", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Cambio: Elegido A veces", Toast.LENGTH_SHORT).show();
                }
            }
        });

                //asignaciones
        togglebtn.setOnClickListener(this);
        wifi.setOnClickListener(this);
        chkacept.setOnClickListener(this);
        btnguardar.setOnClickListener(this);
        si.setOnClickListener(this);
        no.setOnClickListener(this);
        aveces.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.toggle) {
            if (togglebtn.isChecked()) {
                Toast.makeText(this, "toggle ACTIVADO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "toggle DESACTIVADO", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.switchWifi) {
            if (wifi.isChecked()) {
                Toast.makeText(this, "WIFI ACTIVADO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "WIFI DESACTIVADO", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.chkcondiciones) {
            if (chkacept.isChecked()) {
                Toast.makeText(this, "Acepto", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "No acepto", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.btn_estandar) {
            //capturar entradas
            String mensaje;
            mensaje = nombre.getText() + "\n" +
                    numero.getText().toString() + "\n" +
                    decimal.getText().toString();
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.radio1){
            Toast.makeText(this, "On click Si", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.radio2){
            Toast.makeText(this, "On click No", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId()==R.id.radio3){
            Toast.makeText(this, "On click A veces", Toast.LENGTH_SHORT).show();
        }
    }
}
