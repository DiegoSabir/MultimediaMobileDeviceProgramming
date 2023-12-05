package com.example.fecha_hora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {
    String mensaje_con_datos;
    TimePicker timePicker;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = findViewById(R.id.time_picker);
        datePicker = findViewById(R.id.date_picker);
    }

    public void onClickBtn(View view) {
        int version_API = Build.VERSION.SDK_INT;
        if (version_API < 23) {
            mensaje_con_datos = "Fecha: " + datePicker.getDayOfMonth() +
                    "/" + (datePicker.getMonth() + 1) +//Mes inicial=0
                    "/" + datePicker.getYear() +
                    "\nHora: " + timePicker.getCurrentHour() +
                    ":" + timePicker.getCurrentHour();
        } else {
            mensaje_con_datos = "Fecha: " + datePicker.getDayOfMonth() +
                    "/" + (datePicker.getMonth() + 1) +//Mes inicial=0
                    "/" + datePicker.getYear() +
                    "\nHora: " + timePicker.getCurrentHour() +
                    ":" + timePicker.getCurrentHour();
        }


    }
}