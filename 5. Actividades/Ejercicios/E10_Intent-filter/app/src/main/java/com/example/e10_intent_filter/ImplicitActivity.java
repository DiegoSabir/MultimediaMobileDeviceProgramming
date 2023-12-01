package com.example.e10_intent_filter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class ImplicitActivity {













    protected  void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_implicit);
            webView = find.ViewById(R.id.webview_explicit);

            //============================================
            //WebSettings ws = webView.getSettings();
            //ws.setJavaScriptEnabled(true);
            // habilitar javascript para las paginas que lo necesitan
            //============================================

            Intent intent = getIntent();
            Uri uriRecibida = intent.getData();
            webView.loadUrl(uriRecibida.toString()); //loadURL NECESITA string

            //"This shite requieres JavaScript and Cookies to be enabled.

    }
}
