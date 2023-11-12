package com.example.cambiodemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //Atributes
    private EditText etValor;
    private RadioGroup rgConversion;
    private LinearLayout llCantidad;
    private Button btnCambiar;
    private TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.inits();
    }

    private void inits() {
        //Edit Text
        this.etValor = findViewById(R.id.etValor);

        //Radio Groups
        this.rgConversion = findViewById(R.id.rgConversion);

        //LinearLayouts
        this.llCantidad = findViewById(R.id.llCantidad);

        //Buttons
        this.btnCambiar = findViewById(R.id.btnCambiar);

        this.btnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double valor = Double.parseDouble(etValor.getText().toString());
                    conversorMoneda(valor);

                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Introduzca un valor válido.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //TextViews
        this.txtFinal = findViewById(R.id.txtFinal);

        //Defaults
        this.llCantidad.setVisibility(View.GONE);
    }

    private void conversorMoneda(double valor) {
        double tasa = 166.386;
        RadioButton selectedRB = findViewById(rgConversion.getCheckedRadioButtonId());

        if (selectedRB.getId() == R.id.rbEurPts) {
            double resultado = valor * tasa;
            txtFinal.setText(valor + " euros equivalen a " + resultado + " pesetas.");
        }
        else {
            double resultado = valor / tasa;
            txtFinal.setText(valor + " pesetas equivalen a " + resultado + " euros.");
        }
    }
}