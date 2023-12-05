package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;



public class Activity5 extends AppCompatActivity {
    private Button btnEnviarRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        btnEnviarRespuesta = findViewById(R.id.btnEnviarRespuesta);

        btnEnviarRespuesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //volver a la actividad 1 enviándole un dato
                String datoRespuesta = "La actividad 5 envía de vuelta este mensaje a la actividad 1";
                Intent intent = new Intent();
                intent.putExtra("respuesta",datoRespuesta);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("ciclo","Ejecutando onStart Activity 5");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("ciclo","Ejecutando onStop Activity 5");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("ciclo","Ejecutando onResume Activity 5");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy Activity 5");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("ciclo","Ejecutando onPause Activity 5");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart Activity 5");
    }

    //escuchador del boton retorno

}