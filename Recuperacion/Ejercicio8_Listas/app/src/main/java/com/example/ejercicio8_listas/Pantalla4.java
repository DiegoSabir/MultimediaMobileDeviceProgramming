package com.example.ejercicio8_listas;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla4 extends AppCompatActivity {
    private View redView, yellowView, orangeView, greenView, blueView, purpleView, whiteView, grayView, zaphireView;
    private static final int REQUEST_CODE = 1;
    int idColor;

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
        Intent intent = new Intent(Pantalla4.this, Auxiliar.class);
        int backgroundColor = 0;

        switch (v.getId()){
            case R.id.redView:
                backgroundColor = ((ColorDrawable) redView.getBackground()).getColor();
                idColor = 1;
                break;

            case R.id.yellowView:
                backgroundColor = ((ColorDrawable) yellowView.getBackground()).getColor();
                idColor = 2;
                break;

            case R.id.orangeView:
                backgroundColor = ((ColorDrawable) orangeView.getBackground()).getColor();
                idColor = 3;
                break;

            case R.id.greenView:
                backgroundColor = ((ColorDrawable) greenView.getBackground()).getColor();
                idColor = 4;
                break;

            case R.id.blueView:
                backgroundColor = ((ColorDrawable) blueView.getBackground()).getColor();
                idColor = 5;
                break;

            case R.id.purpleView:
                backgroundColor = ((ColorDrawable) purpleView.getBackground()).getColor();
                idColor = 6;
                break;

            case R.id.whiteView:
                backgroundColor = ((ColorDrawable) whiteView.getBackground()).getColor();
                idColor = 7;
                break;

            case R.id.grayView:
                backgroundColor = ((ColorDrawable) grayView.getBackground()).getColor();
                idColor = 8;
                break;

            case R.id.zaphireView:
                backgroundColor = ((ColorDrawable) zaphireView.getBackground()).getColor();
                idColor = 9;
                break;
        }
        intent.putExtra("backgroundColor", backgroundColor);
        intent.putExtra("fromActivity", "Pantalla4");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                boolean resultOk = data.getBooleanExtra("resultOk", false);
                if (resultOk) {
                    if (idColor == 1){
                        redView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 2){
                        yellowView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 3){
                        orangeView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 4){
                        greenView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 5){
                        blueView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 6){
                        purpleView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 7){
                        whiteView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 8){
                        grayView.setVisibility(View.INVISIBLE);
                    }
                    else if (idColor == 9){
                        zaphireView.setVisibility(View.INVISIBLE);
                    }
                }
            }
        }
    }
}

