package com.example.ejercicio5_dialog;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Auxiliar extends AppCompatActivity {
    boolean rbSi = true;
    private LinearLayout llOtrosBtn, llRadioGroup;
    private RadioGroup rgOpciones;
    private Button btnEntendido;
    private View colorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar);

        llOtrosBtn = findViewById(R.id.llOtrosBtn);

        llRadioGroup = findViewById(R.id.llRadioGroup);
        colorView = findViewById(R.id.colorView);
        rgOpciones = findViewById(R.id.rgOpciones);
        btnEntendido = findViewById(R.id.btnEntendido);

        // Obtener el color del intent
        int color = getIntent().getIntExtra("color", Color.WHITE);

        // Establecer el fondo del LinearLayout principal con el color recibido del intent
        llOtrosBtn.setBackgroundColor(color);

        // Determinar que mostrar según la actividad de origen
        String fromActivity = getIntent().getStringExtra("fromActivity");
        switch (fromActivity) {
            case "Pantalla2":
                findViewById(R.id.btnInicio).setVisibility(View.VISIBLE);
                break;

            case "Pantalla3":
                findViewById(R.id.btnInicio).setVisibility(View.VISIBLE);
                findViewById(R.id.btnFinalizar).setVisibility(View.VISIBLE);
                break;

            case "Pantalla4":
                findViewById(R.id.llOtrosBtn).setVisibility(View.GONE);
                findViewById(R.id.llRadioGroup).setVisibility(View.VISIBLE);
                colorView.setBackgroundColor(color);
                break;
        }

        rgOpciones.setOnCheckedChangeListener(escuchadorOpciones);
        btnEntendido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rbSi){
                    finish();
                    Toast.makeText(Auxiliar.this, "Me alegro de que te guste", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(Auxiliar.this, Pantalla4.class);
                    intent.putExtra("color", color);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    public void onClickBtn(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAtras:
                finish();
                break;

            case R.id.btnInicio:
                intent = new Intent(Auxiliar.this, MainActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.btnFinalizar:
                finishAffinity(); // Esto finaliza todas las actividades de la aplicación
                break;
        }
    }

    private RadioGroup.OnCheckedChangeListener escuchadorOpciones = new RadioGroup.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.rbSi){
                rbSi = true;
            }
            else {
                rbSi = false;
            }
        }
    };
}
