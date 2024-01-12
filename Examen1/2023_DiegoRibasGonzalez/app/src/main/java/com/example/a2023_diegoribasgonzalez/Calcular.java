package com.example.a2023_diegoribasgonzalez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calcular extends AppCompatActivity {
    private EditText etMetros, etKg;
    private Button btnCalcular, btnFinalizar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        etMetros = findViewById(R.id.etMetros);
        etKg = findViewById(R.id.etKg);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnFinalizar = findViewById(R.id.btnFinalizar);
    }

    public void onClickBtn(View view) {
        Intent intent;
        int viewId = view.getId();

        if (viewId == R.id.btnCalcular) {

            if (!etMetros.getText().toString().isEmpty() || !etKg.getText().toString().isEmpty()){
                String imc;

                double metros =  Double.parseDouble(etMetros.getText().toString());
                double peso =  Double.parseDouble(etKg.getText().toString());
                double resultado = peso / (metros * metros);
                imc = String.format("%.2f", resultado);

                intent = new Intent(this, Resultado.class);
                intent.putExtra("imc", imc);
                intent.putExtra("resultado", resultado);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
            }

        }
        else if (viewId == R.id.btnFinalizar) {
            finish();
        }
    }
}
