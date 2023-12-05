package com.example.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mensaje;
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
    }


    public void onClickbtn(View view) {
        if (view.getId() == R.id.btn1) {
            btn1.setText("Has pulsado el boton 1");
        }
        if (view.getId() == R.id.btn2) {
            btn2.setText("Has pulsado el boton 2");
        }
        if (view.getId() == R.id.btn3) {
            btn3.setText("b3");
        }
    }
}

