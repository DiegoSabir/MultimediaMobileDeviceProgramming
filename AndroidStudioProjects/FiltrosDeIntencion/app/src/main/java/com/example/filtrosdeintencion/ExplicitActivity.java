package com.example.filtrosdeintencion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class ExplicitActivity extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        webView=findViewById(R.id.webviewexplicita);
        Intent intent= getIntent();
        webView.loadUrl(getIntent().getStringExtra("url"));


    }
}