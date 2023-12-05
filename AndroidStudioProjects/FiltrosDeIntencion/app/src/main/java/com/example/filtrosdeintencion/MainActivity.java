package com.example.filtrosdeintencion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoUrl = findViewById(R.id.textoUrl);
    }

    public void onclickBtn(View view) {
        String strurl = textoUrl.getText().toString();
        if (strurl.isEmpty()) {
            Toast.makeText(this, "Introduzca url", Toast.LENGTH_SHORT).show();
        } else {
            if (view.getId() == R.id.btnexplicito) {
                Intent intent = new Intent(this, ExplicitActivity.class);
                intent.putExtra("url", strurl);
                startActivity(intent);
            } else if (view.getId() == R.id.btnimplicito) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(strurl));//envio necesutamos uri
                startActivity(intent);

            }
        }
    }
}
