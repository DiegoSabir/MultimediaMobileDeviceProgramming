package com.example.ejercicio6_menus;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Pantalla3 extends MenuActivity{
    private View redView, yellowView, orangeView, greenView, blueView, purpleView;
    private static final int REQUEST_CODE = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        redView = findViewById(R.id.redView);
        yellowView = findViewById(R.id.yellowView);
        orangeView = findViewById(R.id.orangeView);
        greenView = findViewById(R.id.greenView);
        blueView = findViewById(R.id.blueView);
        purpleView = findViewById(R.id.purpleView);
    }

    public void onClick(View v) {
        Intent intent = new Intent(Pantalla3.this, Auxiliar.class);
        int backgroundColor = 0;

        switch (v.getId()) {
            case R.id.redView:
                backgroundColor = ((ColorDrawable) redView.getBackground()).getColor();
                break;

            case R.id.yellowView:
                backgroundColor = ((ColorDrawable) yellowView.getBackground()).getColor();
                break;

            case R.id.orangeView:
                backgroundColor = ((ColorDrawable) orangeView.getBackground()).getColor();
                break;

            case R.id.greenView:
                backgroundColor = ((ColorDrawable) greenView.getBackground()).getColor();
                break;

            case R.id.blueView:
                backgroundColor = ((ColorDrawable) blueView.getBackground()).getColor();
                break;

            case R.id.purpleView:
                backgroundColor = ((ColorDrawable) purpleView.getBackground()).getColor();
                break;
        }
        intent.putExtra("backgroundColor", backgroundColor);
        intent.putExtra("fromActivity", "Pantalla3");
        startActivityForResult(intent, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                boolean resultOk = data.getBooleanExtra("resultOk", false);
                if (resultOk) {
                    finish();
                }
            }

            else if (resultCode == RESULT_CANCELED){
                Intent intent = new Intent();
                intent.putExtra("result", true);
                setResult(Auxiliar.RESULT_OK, intent);
                finish();
            }
        }
    }
}