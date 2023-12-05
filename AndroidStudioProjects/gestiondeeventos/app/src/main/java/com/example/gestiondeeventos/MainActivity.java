package com.example.gestiondeeventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvMensaje;
    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMensaje = findViewById(R.id.tvMensaje);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        //instanciar el objeto de la clase auxiliar(que implementó la interfaz)-->objeto "escuchador"
        Auxiliar escuchador1 = new Auxiliar();
        //asignar el escuchador a la vista correspondiente
        btn1.setOnClickListener(escuchador1);
        btn2.setOnClickListener(escuchador2);
        btn4.setOnClickListener(this);

        //crear escuchador(med. close anonimo) y asignarle a la vista de 1 sentencia
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMensaje.setText("Has pulsado boton 3");
            }
        });
    }

    private View.OnClickListener escuchador2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tvMensaje.setText("Has pulsado boton 2");

        }
    };

    @Override
    public void onClick(View view) {
        tvMensaje.setText("Has pulsado boton 4");
    }

    private class Auxiliar implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            tvMensaje.setText("Has pulsado boton 1");

        }
    }
}
