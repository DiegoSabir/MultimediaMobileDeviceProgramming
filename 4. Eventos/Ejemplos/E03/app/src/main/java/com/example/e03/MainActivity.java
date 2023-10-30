package com.example.e03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializar variables
        toggleButton = findViewById(R.id.toggle1);

        //Asignar escuchadores
        toggleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.toggle1){
            if(toggleButton.isChecked()){
                Toast.makeText(this, "toggle ACTIVADO", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "toggle DESACTIVADO", Toast.LENGTH_SHORT).show();
            }
        }
    }
}