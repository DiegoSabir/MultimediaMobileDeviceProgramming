package com.example.ejercicio4_activies_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llBtnPantallas;

    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llBtnPantallas = findViewById(R.id.llBtnPantallas);
    }

    public void onClickBtn(View view){
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btnPantalla1:
                intent = new Intent(MainActivity.this, Pantalla1.class);
                break;

            case R.id.btnPantalla2:
                intent = new Intent(MainActivity.this, Pantalla2.class);
                break;

            case R.id.btnPantalla3:
                intent = new Intent(MainActivity.this, Pantalla3.class);
                break;

            case R.id.btnPantalla4:
                intent = new Intent(MainActivity.this, Pantalla4.class);
                break;
        }
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                boolean result = data.getBooleanExtra("result", false);
                if (result) {
                    finish();
                }
            }
        }
    }
}