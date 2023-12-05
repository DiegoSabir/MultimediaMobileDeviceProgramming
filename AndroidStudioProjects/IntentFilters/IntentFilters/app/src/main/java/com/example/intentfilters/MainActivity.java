package com.example.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_url = findViewById(R.id.et_url);

    }

    public void onClickBtn(View view) {
        Intent intent;
        String url = et_url.getText().toString();
        if (url.equals(""))
            Toast.makeText(this, "URL Vacia.", Toast.LENGTH_SHORT).show();
        if (view.getId() == R.id.btnExplicito) {
            intent = new Intent(this, ExplicitActivity.class);
            intent.putExtra("url_key", url);
            startActivity(intent);
        } else if (view.getId() == R.id.btnImplicito){
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);

        }

    }

 }
