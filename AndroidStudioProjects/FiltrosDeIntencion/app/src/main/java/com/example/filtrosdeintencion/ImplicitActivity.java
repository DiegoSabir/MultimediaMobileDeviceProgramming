package com.example.filtrosdeintencion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class ImplicitActivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        webview = findViewById(R.id.webviewimplicita);
        Intent intent = getIntent();
        Uri urirecibida = intent.getData();
        webview.loadUrl(urirecibida.toString());
    }
}