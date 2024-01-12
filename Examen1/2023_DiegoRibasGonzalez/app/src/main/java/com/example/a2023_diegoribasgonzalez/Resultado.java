package com.example.a2023_diegoribasgonzalez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado  extends AppCompatActivity {
    private TextView tvResultado, tvCorrecto, tvSobrepeso, tvObesidad;
    private ImageView ivCorrecto, ivSobrepeso, ivObesidad;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        tvResultado = findViewById(R.id.tvResultado);
        tvCorrecto = findViewById(R.id.tvCorrecto);
        tvSobrepeso = findViewById(R.id.tvSobrepeso);
        tvObesidad = findViewById(R.id.tvObesidad);

        ivCorrecto = findViewById(R.id.ivCorrecto);
        ivSobrepeso = findViewById(R.id.ivSobrepeso);
        ivObesidad = findViewById(R.id.ivObesidad);

        Intent intent = getIntent();

        String imc = intent.getStringExtra("imc");



        int valor = intent.getIntExtra("resultado", 0);

        tvResultado.setText("IMC = " + imc);

        mostrar(valor);
    }

    public void mostrar(double valor){
        if(valor >= 30){
            ivObesidad.setVisibility(View.VISIBLE);
            tvObesidad.setVisibility(View.VISIBLE);
        }
        else if (valor >= 25 && valor < 30){
            ivSobrepeso.setVisibility(View.VISIBLE);
            tvSobrepeso.setVisibility(View.VISIBLE);
        }
        else if (valor < 25){
            ivCorrecto.setVisibility(View.VISIBLE);
            ivCorrecto.setVisibility(View.VISIBLE);
        }
    }
}
