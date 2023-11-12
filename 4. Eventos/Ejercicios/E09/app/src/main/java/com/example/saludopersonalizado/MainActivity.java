package com.example.saludopersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText etxtNombre;
    private EditText etxtAnho;
    private RadioGroup rgGenero, rgDespedida;
    private String genero = "Sra. ";
    private LinearLayout llDespedida;
    private CheckBox chkDespedida;
    private String despedida = "Adiós.";
    private Button btnSaludo;
    private TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inits();
    }

    private void inits() {

        //Edit Text
        this.etxtNombre = findViewById(R.id.etxtNombre);
        this.etxtAnho = findViewById(R.id.etxtAnho);

        //Radio Groups
        this.rgGenero = findViewById(R.id.rgGenero);
        this.rgDespedida = findViewById(R.id.rgDespedida);

        rgGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.sr) {
                    genero = "Sr. ";
                }
                else if (checkedId == R.id.sra) {
                    genero = "Sra. ";
                }
                else {
                    genero = "";
                }
            }
        });

        rgDespedida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                if (checkedId == R.id.rbtnAdios) {
                    despedida = "Adios.";
                }
                else {
                    despedida = "Hasta Luego.";
                }
            }
        });

        //LinearLayouts
        this.llDespedida = findViewById(R.id.llDespedida);

        //CheckBoxes
        this.chkDespedida = findViewById(R.id.chkDespedida);

        this.chkDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (chkDespedida.isChecked()) {
                    llDespedida.setVisibility(View.VISIBLE);
                }
                else {
                    llDespedida.setVisibility(View.GONE);
                }
            }
        });

        //Buttons
        this.btnSaludo = findViewById(R.id.btnSaludo);

        this.btnSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String printable = "Hola " + genero + etxtNombre.getText().toString() + "\n";
                    String edad = comprobarEdad() ? "Eres mayor de edad\n" : "Eres menor de edad\n";
                    printable = printable + edad;

                    if (chkDespedida.isChecked()) {
                        printable = printable + despedida;
                        txtFinal.setText(printable);
                    }
                    else {
                        txtFinal.setText(printable);
                    }

                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Porfavor indique nombre y edad.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //TextViews
        this.txtFinal = findViewById(R.id.txtFinal);

        //Defaults
        this.llDespedida.setVisibility(View.GONE);
    }

    private boolean comprobarEdad() {
        int y = Integer.parseInt(this.etxtAnho.getText().toString());
        int current = Calendar.getInstance().get(Calendar.YEAR);

        if ((current - y) >= 18) {
            return true;
        }
        else {
            return false;
        }
    }
}