package com.example.ejercicio3_activies_v2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Auxiliar extends AppCompatActivity {
    private LinearLayout llOtrosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxiliar);

        llOtrosBtn = findViewById(R.id.llOtrosBtn);

        int backgroundColor = getIntent().getIntExtra("backgroundColor", 0);
        llOtrosBtn.setBackgroundColor(backgroundColor);

        String fromActivity = getIntent().getStringExtra("fromActivity");
        switch (fromActivity) {
            case "Pantalla1":
                break;

            case "Pantalla2":
                findViewById(R.id.btnInicio).setVisibility(View.VISIBLE);
                break;

            case "Pantalla3":
                findViewById(R.id.btnInicio).setVisibility(View.VISIBLE);
                findViewById(R.id.btnFinalizar).setVisibility(View.VISIBLE);
                break;
        }
    }

    public void onClickBtn(View view){
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAtras:
                intent = new Intent();
                intent.putExtra("resultOk", false);
                setResult(Auxiliar.RESULT_OK, intent);
                finish();
                break;

            case R.id.btnInicio:
                intent = new Intent();
                intent.putExtra("resultOk", true);
                setResult(Auxiliar.RESULT_OK, intent);
                finish();
                break;

            case R.id.btnFinalizar:
                intent = new Intent();
                intent.putExtra("resultOk", true);
                setResult(Auxiliar.RESULT_CANCELED, intent);
                finish();
                break;
        }
    }
}

