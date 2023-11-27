package com.example.e10_intent_filter;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ExplicitActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.id.activity_explicit);
        webView = findViewById(R.id.webview_explicit);

        //capcturar el intent que nos han enviado
        Intent intent = getIntent();
        String URLrecibida = intent.getExtras().getString("url_key");

        //loadUrl() carga una URL en un objeto webview
        webView.loadUrl(URLrecibida);
    }
}
