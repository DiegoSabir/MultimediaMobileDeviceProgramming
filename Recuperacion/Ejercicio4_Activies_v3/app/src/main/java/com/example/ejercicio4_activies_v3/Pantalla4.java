package com.example.ejercicio4_activies_v3;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla4 extends AppCompatActivity {
    private View redView, yellowView, orangeView, greenView, blueView, purpleView, whiteView, grayView, zaphireView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4);

        redView = findViewById(R.id.redView);
        yellowView = findViewById(R.id.yellowView);
        orangeView = findViewById(R.id.orangeView);
        greenView = findViewById(R.id.greenView);
        blueView = findViewById(R.id.blueView);
        purpleView = findViewById(R.id.purpleView);
        whiteView = findViewById(R.id.whiteView);
        grayView = findViewById(R.id.grayView);
        zaphireView = findViewById(R.id.zaphireView);
    }

    public void onClick(View v) {
        Intent intent;
        int backgroundColor;

        switch (v.getId()){
            case R.id.redView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) redView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla3");
                startActivity(intent);
                break;

            case R.id.yellowView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) yellowView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla3");
                startActivity(intent);
                break;

            case R.id.orangeView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) orangeView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla3");
                startActivity(intent);
                break;

            case R.id.greenView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) greenView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla3");
                startActivity(intent);
                break;

            case R.id.blueView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) blueView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla3");
                startActivity(intent);
                break;

            case R.id.purpleView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) purpleView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla2");
                startActivity(intent);
                break;

            case R.id.whiteView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) whiteView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla2");
                startActivity(intent);
                break;

            case R.id.grayView:
                intent = new Intent(Pantalla4.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) grayView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla2");
                startActivity(intent);
                break;

            case R.id.zaphireView:
                intent = new Intent(Pantalla3.this, Auxiliar.class);
                backgroundColor = ((ColorDrawable) zaphireView.getBackground()).getColor();
                intent.putExtra("backgroundColor", backgroundColor);
                intent.putExtra("fromActivity", "Pantalla2");
                startActivity(intent);
                break;
        }
    }
}