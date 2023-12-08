package com.example.cambiodemoneda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbToEur, rbToPts;
    private EditText etCantidad;
    private TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbToEur = findViewById(R.id.rbToEur);
        rbToPts = findViewById(R.id.rbToPts);

        etCantidad = findViewById(R.id.etCantidad);

        tvMensaje = findViewById(R.id.tvMensaje);
    }

    public void cambiar(View v) {
        if (!etCantidad.getText().toString().isEmpty()){
            double cantidad =  Double.parseDouble(etCantidad.getText().toString());
            double tasa = 166.386;
            String filtroResultado;

            if (rbToEur.isChecked()){
                double resultado = cantidad / tasa;
                filtroResultado = String.format("%.2f", resultado);
                tvMensaje.setText(cantidad + " pesetas equivalen a " + filtroResultado + " euros.");
            }
            else {
                double resultado = cantidad * tasa;
                filtroResultado = String.format("%.2f", resultado);
                tvMensaje.setText(cantidad + " euros equivalen a " + filtroResultado + " pesetas.");
            }
        }
        else {
            Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        }
    }
}