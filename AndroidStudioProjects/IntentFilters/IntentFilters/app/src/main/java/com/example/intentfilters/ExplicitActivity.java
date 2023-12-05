package com.example.intentfilters;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        webView = findViewById(R.id.webview_explicit);
        //capturar el intent que nos han enviado
        Intent intent = getIntent();
        String URLrecibida = intent.getExtras().getString("url_key");
        webView.loadUrl(URLrecibida);
    }
}