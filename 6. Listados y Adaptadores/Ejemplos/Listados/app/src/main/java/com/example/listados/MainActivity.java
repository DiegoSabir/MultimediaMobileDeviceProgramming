package com.example.listados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.listados.listviews.ListView1_Activity;
import com.example.listados.listviews.ListView2_Activity;
import com.example.listados.listviews.ListView3_Activity;
import com.example.listados.listviews.ListView4_Activity;
import com.example.listados.listviews.ListView5_Activity;
import com.example.listados.listviews.ListView6_Activity;
import com.example.listados.spinners.Spinner_1_Activity;
import com.example.listados.spinners.Spinner_2_Activity;
import com.example.listados.spinners.Spinner_3_Activity;
import com.example.listados.spinners.Spinner_4_Activity;
import com.example.listados.spinners.Spinner_5_Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("NonConstantResourceId")
    public void onClickBtnListados(View view) {
        Intent intent = new Intent();

        switch (view.getId()){
            case R.id.btn1_spinner:
                intent.setClass(this, Spinner_1_Activity.class);
                break;

            case R.id.btn2_spinner:
                intent.setClass(this, Spinner_2_Activity.class);
                break;

            case R.id.btn3_spinner:
                intent.setClass(this, Spinner_3_Activity.class);
                break;

            case R.id.btn4_spinner:
                intent.setClass(this, Spinner_4_Activity.class);
                break;

            case R.id.btn5_spinner:
                intent.setClass(this, Spinner_5_Activity.class);
                break;

            //LISTVIEWS
            case R.id.btn1_listView:
                intent.setClass(this, ListView1_Activity.class);
                break;

            case R.id.btn2_listView:
                intent.setClass(this, ListView2_Activity.class);
                break;

            case R.id.btn3_listView:
                intent.setClass(this, ListView3_Activity.class);
                break;

            case R.id.btn4_listView:
                intent.setClass(this, ListView4_Activity.class);
                break;

            case R.id.btn5_listView:
                intent.setClass(this, ListView5_Activity.class);
                break;

            case R.id.btn6_listView:
                intent.setClass(this, ListView6_Activity.class);
                break;
        }
        startActivity(intent);
    }
}