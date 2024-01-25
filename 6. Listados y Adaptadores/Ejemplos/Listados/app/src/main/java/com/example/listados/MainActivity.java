package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtnListados(View view){
        Intent i = new Intent();
        switch(view.getId()){
            case R.id.btn1_spinner:
                i.setClass(this, Spinner_1_Activity.class);
                break;

            case R.id.btn2_spinner:
                i.setClass(this, Spinner_2_Activity.class);
                break;

            case R.id.btn3_spinner:
                i.setClass(this, Spinner3_FromRecursos.class);
                break;

            case R.id.btn4_spinner:
                i.setClass(this, Spinner4_Dinamico.class);
                break;

            case R.id.btn5_spinner:
                i.setClass(this, Spinner5_DinamicoTrue.class);
                break;

            case R.id.btn1_listView:
                i.setClass(this, ListView_1_Activity.class);
                break;


        }//end switch

        startActivity(i);
    }
}