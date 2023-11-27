package com.example.e10_intent_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUrl = findViewById(R.id.et_url);
    }

    public void onClickBtn(View view) {
        String strUrl = etUrl.getText().toString();
        //testear entrada
        if(strUrl.isEmpty()){
            Toast.makeText(this, "Introduzca URL ", Toast.LENGTH_SHORT).show();
        }
        else{
            if(view.getId() == R.id.btn_explicito){
                Intent intent = new Intent(this, ExplicitActivity.class);
                intent.putExtra("url_key", strUrl);
                startActivity(intent);
            }
            else if (view.getId() == R.id.btn_implicito) {
                Intent intent = new Intent(Intent.ACTION_VIEW, uri.parse);
                startActivity(intent);
            }
        }
    }
}