package com.example.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Log.i("ciclo","Ejecutando onStart Activity 2");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("ciclo","Ejecutando onStart Activity 2");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("ciclo","Ejecutando onStop Activity 2");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("ciclo","Ejecutando onResume Activity 2");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("ciclo","Ejecutando onDestroy Activity 2");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("ciclo","Ejecutando onPause Activity 2");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("ciclo","Ejecutando onRestart Activity 2");
    }
}