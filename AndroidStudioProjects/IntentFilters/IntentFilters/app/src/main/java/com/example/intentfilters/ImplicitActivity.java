package com.example.intentfilters;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class ImplicitActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        webView = findViewById(R.id.webview_implicit);

        //==================================================================//
        //===  Habilitar JavaScript para las paginas que lo necesitan  ====//
        //   La pagina de youtube lo necesita para cargar en contenido    //
        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        //==============================================================//

        Intent intent = getIntent();
        Uri urirecibida = intent.getData();
        webView.loadUrl(urirecibida.toString());
    }
}