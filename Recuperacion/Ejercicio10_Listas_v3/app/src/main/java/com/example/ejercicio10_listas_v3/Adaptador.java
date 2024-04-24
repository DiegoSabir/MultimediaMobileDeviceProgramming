package com.example.ejercicio10_listas_v3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter {
    private Activity context;
    private String[] arrayPantallas, arrayInformacionColores, arrayNumeroColores;
    private int layoutPersonalizado;

    public Adaptador(@NonNull Activity context, int layoutPersonalizado, String[] arrayPantallas, String[] arrayInformacionColores, String[] arrayNumeroColores) {
        super(context, layoutPersonalizado, arrayPantallas);
        this.context = context;
        this.arrayPantallas = arrayPantallas;
        this.arrayInformacionColores = arrayInformacionColores;
        this.arrayNumeroColores = arrayNumeroColores;
        this.layoutPersonalizado = layoutPersonalizado;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(layoutPersonalizado,null);

        TextView tvOpcionFila = fila.findViewById(R.id.tvOpcionFila);
        TextView tvInformacionFila = fila.findViewById(R.id.tvInformacionFila);
        TextView tvNumerosColoresFila = fila.findViewById(R.id.tvNumerosColoresFila);

        tvOpcionFila.setText(arrayPantallas[position]);
        tvInformacionFila.setText(arrayInformacionColores[position]);
        tvNumerosColoresFila.setText(arrayNumeroColores[position]);

        return fila;
    }
}
