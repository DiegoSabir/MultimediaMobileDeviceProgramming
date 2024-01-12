package com.example.a2023_diegoribasgonzalez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class Informacion  extends AppCompatActivity {
    private RadioGroup rgOpcionesInformacion;
    private RadioButton rbEnlace, rbTelefono;
    private Button btnOk, btnAtras;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        rbEnlace = findViewById(R.id.rbEnlace);
        rbTelefono = findViewById(R.id.rbTelefono);

        btnOk = findViewById(R.id.btnOk);
        btnAtras = findViewById(R.id.btnAtras);

    }

    public void onClickBtn(View view) {

    }
}
