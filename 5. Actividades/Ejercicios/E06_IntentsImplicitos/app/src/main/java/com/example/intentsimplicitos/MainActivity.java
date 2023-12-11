package com.example.intentsimplicitos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //cte identificadora de la llamada de teléfono
    private static final int LLAMADA_TELEFONICA_DIRECTA = 0;
    private static final int LLAMADA_TELEFONICA_DIRECTA_COMPAT = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickBtn(View view) {
        Intent intent;
        int viewId = view.getId();

        if (viewId == R.id.btnMostrar) {
            //Genera la acción del intent implicito: ACTION_VIEW
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
            startActivity(intent);
        }

        else if (viewId == R.id.btnLlamar) {
            //Genera la acción del intent implicito: ACTION_CALL
            if (Build.VERSION.SDK_INT >= 23) {
                if (checkSelfPermission(android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)604053218"));
                    startActivity(intent);
                }
                else {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, LLAMADA_TELEFONICA_DIRECTA);
                }
            }
            else {
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)604053218"));
                startActivity(intent);
            }
        }

        else if (viewId == R.id.btnMarcar) {
            /** Genera la accion del intent implicito: ACTION_DIAL
            intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
            */

            //Genera la acción del intent implicito: ACTION_DIAL con un numero premarcado
            intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+34)604053218"));
            startActivity(intent);
        }

        else if (viewId == R.id.btnAbrir) {
            //Genera la acción del intent implicito: ACTION_VIEW
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.es"));
            startActivity(intent);
        }

        else if (viewId == R.id.btnMapa) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:42.25,-8.68"));
            intent.setPackage("com.google.android.apss.map");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();
            }
        }
        else if (viewId == R.id.btnOtraApp) {
            intent = new Intent();
            intent.setClassName("com.example.cuenta_clicks_v2", "com.example.cuenta_clicks_v2.MainActivity");
            PackageManager pm = getPackageManager();
            List actividadesPosibles = pm.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (actividadesPosibles.size()>0){
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Esta acción no se puede realizar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Metodo en donde recibimos la respuesta que ha dado el usuario
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LLAMADA_TELEFONICA_DIRECTA) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Respuesta cuando el permiso es concedido
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+34)986430137"));
                startActivity(intent);
                Toast.makeText(this, "El usuario ha permitido el permiso de llamada", Toast.LENGTH_SHORT).show();
            }
            else {
                //Respuesta cuando el permiso es denegado
                Toast.makeText(this, "El usuario ha denegado el permiso de llamada", Toast.LENGTH_SHORT).show();
            }
        }
    }
}