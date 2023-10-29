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
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMensaje = findViewById(R.id.tvMensaje);
        radioGroup = findViewById(R.id.radioGroup);
        btnTexto = findViewById(R.id.btnTexto);
        btnImagen = findViewById(R.id.btnImagen);
        btnAceptar = findViewById(R.id.btnAceptar);

        // Establece un Listener para el botón Aceptar
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == btnTexto.getId()) {

                    tvMensaje.setText("GIRANDO!!!!!");
                    tvMensaje.setTextSize(30);
                    tvMensaje.setTextColor(getResources().getColor(R.color.red));
                    tvMensaje.setRotation(45);
                }
                else if (selectedId == btnImagen.getId()) {
                // Si se selecciona la opción de imagen, muestra una imagen (debes tener una imagen con el ID imageView en tu layout XML)
                tvMensaje.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
            }

            }
        });
    }
}

