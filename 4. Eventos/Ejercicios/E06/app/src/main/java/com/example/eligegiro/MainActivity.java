package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView label;
    private RadioGroup radiog;
    private RadioButton rbtView;
    private RadioButton rbtImagen;
    private Button btnAceptar;

    private EditText etxtGrados;

    private int grados = 0;

    float rotation=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.label = findViewById(R.id.label);
        this.rbtView = findViewById(R.id.rbtView);
        this.rbtImagen = findViewById(R.id.rbtImagen);
        this.btnAceptar = findViewById(R.id.btnAceptar);
        this.etxtGrados = findViewById(R.id.etxtGrados);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                label.setText("");
                try {
                    grados = Integer.parseInt(etxtGrados.getText().toString());
                    if (rbtView.isChecked()) {
                        label.setText("HOLAAAAAAAA");
                        label.setTextSize(getResources().getDimension(R.dimen.letterSize));
                        label.setBackgroundColor(getResources().getColor(R.color.cyan));
                        label.setTextColor(getResources().getColor(R.color.red));
                    }
                    else if (rbtImagen.isChecked()) {
                        label.setBackground(getDrawable(R.drawable.emoticono));
                    }

                }
                catch (Exception ex) {
                    Toast.makeText(MainActivity.this, "Valor de grados no valido", Toast.LENGTH_SHORT).show();
                }
            }
        });


        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                label.setRotation(rotation);
                rotation+=grados;
                if (rotation>=360){
                    rotation=0;
                }
            }
        });
    }
}