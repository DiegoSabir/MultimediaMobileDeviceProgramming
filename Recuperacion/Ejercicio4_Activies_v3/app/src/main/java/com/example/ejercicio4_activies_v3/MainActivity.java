package com.example.ejercicio4_activies_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llBtnPantallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBtnPantallas = findViewById(R.id.llBtnPantallas);
    }

    public void onClickBtn(View view){
        Intent intent;
        switch (view.getId()) {

            case R.id.btnPantalla1:
                intent = new Intent(MainActivity.this, Pantalla1.class);
                startActivity(intent);
                break;

            case R.id.btnPantalla2:
                intent = new Intent(MainActivity.this, Pantalla2.class);
                startActivity(intent);
                break;

            case R.id.btnPantalla3:
                intent = new Intent(MainActivity.this, Pantalla3.class);
                startActivity(intent);
                break;

            case R.id.btnPantalla4:
                intent = new Intent(MainActivity.this, Pantalla4.class);
                startActivity(intent);
                break;
        }
    }
}