package com.example.a2023_diegoribasgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView ivLogo;
    private TextView tvTitulo2;
    private RadioGroup rgOpciones;
    private RadioButton rbCalcular, rbInformacion;
    private Button btnCalcular, btnInformacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.ivLogo);

        tvTitulo2 = findViewById(R.id.tvTitulo2);

        rgOpciones = findViewById(R.id.rgOpciones);

        rbCalcular = findViewById(R.id.rbCalcular);
        rbInformacion = findViewById(R.id.rbInformacion);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnInformacion = findViewById(R.id.btnInformacion);

        listeners();
    }

    private void listeners(){
        ivLogo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ivLogo.setVisibility(View.GONE);
                tvTitulo2.setVisibility(View.VISIBLE);
                rgOpciones.setVisibility(View.VISIBLE);
                btnCalcular.setVisibility(View.VISIBLE);
                return false;
            }
        });

        rgOpciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbCalcular){
                    btnCalcular.setVisibility(View.VISIBLE);
                    btnInformacion.setVisibility(View.GONE);
                }
                else if(checkedId == R.id.rbInformacion){
                    btnInformacion.setVisibility(View.VISIBLE);
                    btnCalcular.setVisibility(View.GONE);
                }
            }
        });
    }

    public void onClickBtn(View view) {
        Intent intent;
        int viewId = view.getId();

        if (viewId == R.id.btnCalcular) {
            intent = new Intent(this, Calcular.class);
            startActivity(intent);
        }
        else if (viewId == R.id.btnInformacion) {
            intent = new Intent(this, Informacion.class);
            startActivity(intent);
        }
    }


}