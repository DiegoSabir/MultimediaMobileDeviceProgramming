package com.example.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.pm.PackageManager;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private String DatoEnviar;

    TextView tvRespuesta;

    private static final int CODIGO_LLAMADA_ACT5 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRespuesta = findViewById(R.id.tvRespuesta);
        Log.i("ciclo","Ejecutando onCreate Activity 1");
    }

    public void onClickCambioActivity(View view) {
        if (view.getId() == R.id.btnLlamadaActividad2) {
            //crear un objeto Intent
            Intent intent = new Intent(this, Activity2.class);
            //realizar la llamada
            startActivity(intent);
        } else if (view.getId() == R.id.btnLlamadaActividad3) {
            Intent intent = new Intent(this, Activity3.class);
            DatoEnviar = "Activity 1 le envía este mensaje a la Activity 3";
            //añadir un dato al input
            intent.putExtra("mensaje", DatoEnviar);
            startActivity(intent);

        } else if (view.getId() == R.id.btnLlamadaActividad4) {
            Intent intent = new Intent(this, Activity4.class);
            DatoEnviar = "Activity 1 envía mensaje a Activity 4 med Bundle";
            //crear el objeto Bundle
            Bundle bundle = new Bundle();
            //añadir datos al bundle
            bundle.putString("mensaje", DatoEnviar);
            //asociar el bundle con el intent
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (view.getId() == R.id.btnLlamadaEsperandoRespuesta) {
            Intent intent = new Intent(this, Activity5.class);
            //llamada esperando respuesta
            startActivityForResult(intent, CODIGO_LLAMADA_ACT5);
        }
        else if (view.getId()==R.id.btnLlamadaOtraApp){
            Intent intent = new Intent();
            intent.setClassName("com.example.cuentaclicks","com.example.cuentaclicks.MainActivity");
            PackageManager pm = getPackageManager();
            startActivity(intent);
            /*List actividadesPosibles = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (actividadesPosibles.size()>0){
                startActivity(intent);
            }else {
                Toast.makeText(this, "No se puede realizar esta acción", Toast.LENGTH_SHORT).show();
            }*/
        }
        else if (view.getId() == R.id.btnLlamarCaculadora) {
            Intent intent = new Intent();
            intent.setClassName("com.android.calculator2","com.android.calculator2.Calculator");
            startActivity(intent);
        }

        else if (view.getId() == R.id.btnLlamarAjustes) {
            Intent intent = new Intent();
            intent.setClassName("com.android.settings","com.android.settings.Settings");
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("ciclo","Ejecutando onAtivityResult Activity 1");
        //vemos que activity no está contestando
        if (requestCode == CODIGO_LLAMADA_ACT5) {
            //testeamos el codigo del resultado
            if (resultCode == RESULT_OK) {
                //operaciones si la actividad llamada finaliza según lo previsto
                Toast.makeText(this, "Todo ok", Toast.LENGTH_SHORT).show();
                tvRespuesta.setText(data.getStringExtra("respuesta"));

            } else{
                //operaciones si la actividad llamada NO finaliza según lo previsto
                Toast.makeText(this,"Algo fallo",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("ciclo","Ejecutando onStart Activity 1");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("ciclo","Ejecutando onStop Activity 1");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("ciclo","Ejecutando onResume Activity 1");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy Activity 1");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("ciclo","Ejecutando onPause Activity 1");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart Activity 1");
    }

}