package com.example.learnchemistry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final static int NOTIFICATION_1 = 1;
    private View ivLogo;
    private LinearLayout llQuimicos;
    private ListView lvQuimicos;
    private ArrayList<Quimico> arrayQuimicos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.ivLogo);
        llQuimicos = findViewById(R.id.llQuimicos);

        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivLogo.setVisibility(View.GONE);
                llQuimicos.setVisibility(View.VISIBLE);
            }
        });

        lvQuimicos = findViewById(R.id.lvQuimicos);

        inicializarArrays();

        asociarAdapter();
        itemClickListener_ListView();

    }

    private void inicializarArrays() {
        String[] nombresQuimicos = getResources().getStringArray(R.array.nombresQuimicos);
        TypedArray imagenesQuimicos = getResources().obtainTypedArray(R.array.imagenesQuimicos);

        for (int i = 0; i < nombresQuimicos.length; i++) {
            arrayQuimicos.add(new Quimico(nombresQuimicos[i], imagenesQuimicos.getResourceId(i, -1)));
        }
    }

    private void asociarAdapter() {
        Adaptador adapter = new Adaptador(this, R.layout.lista, arrayQuimicos);

        lvQuimicos.setAdapter(adapter);
    }

    private void itemClickListener_ListView() {
        lvQuimicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Quimico quimicoSeleccionado = (Quimico) adapterView.getItemAtPosition(i);

                //crear objeto Intent
                Intent intent = new Intent(MainActivity.this, Comprobar.class);
                //realizar la llamada
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void onClickBtn2(View view) {
        Intent intent = new Intent(this, Insertar.class);
        startActivity(intent);
    }


    private void showNotification() {
        // Convertir el drawable a bitmap
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.flask1);

        Notification.Builder builder = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.star_on)

                .setTicker("Soy el mensaje opcional")       //Esto no se ve en las APIs actuales

                .setContentTitle("Tiene mas de 2 errores")
                .setContentText("Soy el contenido")

                .setStyle(new Notification.BigTextStyle()
                        .bigText("Consulte la web para aprender mas"))

                .setAutoCancel(true)

                .setLargeIcon(largeIcon);


        //Asociar acción
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getResources().getString(R.string.enlace)));      //Al pulsar la notificación te lleva a otra Activity
        startActivity(intent);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        //Asociar el PendingIntent con la notificación
        builder.setContentIntent(pendingIntent);

        //Lanzar la notificación
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();

        notificationManager.notify(NOTIFICATION_1, notification);
    }

}