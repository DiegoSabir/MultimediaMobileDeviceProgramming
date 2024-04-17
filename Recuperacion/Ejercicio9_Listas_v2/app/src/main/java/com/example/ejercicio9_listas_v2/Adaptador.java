package com.example.ejercicio9_listas_v2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Adaptador extends ArrayAdapter<String> {
    private Activity context;
    private int layoutPersonalizado;
    private final String[] arrayPaddings;

    public Adaptador(@NonNull Activity context, int layoutPersonalizado, String[] arrayPaddings) {
        super(context, layoutPersonalizado, arrayPaddings);

        this.context = context;
        this.layoutPersonalizado = layoutPersonalizado;
        this.arrayPaddings = arrayPaddings;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflamos nuestro layout personalizado
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(layoutPersonalizado, null);

        //Capturamos los id de cada componente de nuestro layout
        TextView tvPadding = fila.findViewById(R.id.tvTituloFila);

        //Insertar cada valor (planeta/imagen)
        tvPadding.setText(arrayPaddings[position]);

        return fila;
    }
}
