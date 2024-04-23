package com.example.ejercicio8_listas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
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
            case "Pantalla1":
                break;

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
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("resultOk", true);
                    setResult(Auxiliar.RESULT_OK, returnIntent);
                    finish();
                }
            }
        });
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
                showDialogWithOptions();
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "El usuario no contesta...", Toast.LENGTH_SHORT).show();
    }

    private void showDialogWithOptions() {
        new AlertDialog.Builder(this)
                .setTitle("CIERRE DE APP!")
                .setMessage("La app se va a cerrar\nEsta seguro?")
                .setIcon(R.drawable.colors_icon)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intentFinish = new Intent();
                        intentFinish.putExtra("resultOK", true);
                        setResult(4, intentFinish);
                        finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }
}

