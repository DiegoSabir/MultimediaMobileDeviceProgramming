package com.example.ejercicio11_12_listas_v4;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla1 extends AppCompatActivity {
    private View redView, yellowView, greenView, blueView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        redView = findViewById(R.id.redView);
        yellowView = findViewById(R.id.yellowView);
        greenView = findViewById(R.id.greenView);
        blueView = findViewById(R.id.blueView);
    }

    public void onClick(View v) {
        Intent intent = new Intent(Pantalla1.this, Auxiliar.class);
        int backgroundColor = 0;

        switch (v.getId()){
            case R.id.redView:
                backgroundColor = ((ColorDrawable) redView.getBackground()).getColor();
                break;

            case R.id.yellowView:
                backgroundColor = ((ColorDrawable) yellowView.getBackground()).getColor();
                break;

            case R.id.greenView:
                backgroundColor = ((ColorDrawable) greenView.getBackground()).getColor();
                break;

            case R.id.blueView:
                backgroundColor = ((ColorDrawable) blueView.getBackground()).getColor();
                break;
        }
        intent.putExtra("backgroundColor", backgroundColor);
        intent.putExtra("fromActivity", "Pantalla1");
        startActivity(intent);
    }
}
