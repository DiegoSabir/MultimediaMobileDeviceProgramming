package com.example.ejercicio4_activies_v3;

import android.content.Intent;
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

        int backgroundColor = getIntent().getIntExtra("backgroundColor", 0);
        llOtrosBtn.setBackgroundColor(backgroundColor);

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
                colorView.setBackgroundColor(backgroundColor);
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
                    intent.putExtra("color", backgroundColor);
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
                finish();
                startActivity(intent);
                break;

            case R.id.btnFinalizar:
                finishAffinity();
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

