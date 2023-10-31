package com.example.eligegiro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvMensaje;
    private RadioGroup radioGroup;
    private RadioButton btnTexto;
    private RadioButton btnImagen;
    private Button btnAceptar;
    private TextView tvGirando;
    private ImageView imgEmoticono;
    float angulo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMensaje = findViewById(R.id.tvMensaje);
        radioGroup = findViewById(R.id.radioGroup);
        btnTexto = findViewById(R.id.btnTexto);
        btnImagen = findViewById(R.id.btnImagen);
        btnAceptar = findViewById(R.id.btnAceptar);
        imgEmoticono = findViewById(R.id.imgEmoticono);
        tvGirando = findViewById(R.id.tvGirando);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                tvMensaje.setVisibility(View.GONE);
                radioGroup.setVisibility(View.GONE);
                btnAceptar.setVisibility(View.GONE);

                if (selectedId == btnTexto.getId()) {
                    tvGirando.setVisibility(View.VISIBLE);
                    tvGirando.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            angulo += 45;
                            tvGirando.setRotation(angulo);
                        }
                    });
                }
                else if (selectedId == btnImagen.getId()) {
                    imgEmoticono.setVisibility(View.VISIBLE);
                    imgEmoticono.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            angulo += 45;
                            imgEmoticono.setRotation(angulo);
                        }
                    });
                }
            }
        });
    }
}

