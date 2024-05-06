package com.example.ejercicio13_listas_v5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter {
    private Activity context;
    private ArrayList<Pantalla> arrayPantallas;
    private int layoutPersonalizado;

    public Adaptador(@NonNull Activity context, int layoutPersonalizado, ArrayList arrayPantallas) {
        super(context, layoutPersonalizado, arrayPantallas);
        this.context = context;
        this.arrayPantallas = arrayPantallas;
        this.layoutPersonalizado = layoutPersonalizado;
    }

    static class ViewHolder {
        TextView tvOpcionFila;
        TextView tvInformacionFila;
        TextView tvNumerosColoresFila;
        ImageView ivImagenPantallaFila;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;
        ViewHolder holder;

        if (fila == null){
            LayoutInflater inflater = context.getLayoutInflater();

            fila = inflater.inflate(layoutPersonalizado, null);

            holder = new ViewHolder();
            holder.tvOpcionFila = fila.findViewById(R.id.tvOpcionFila);
            holder.tvInformacionFila = fila.findViewById(R.id.tvInformacionFila);
            holder.tvNumerosColoresFila = fila.findViewById(R.id.tvNumerosColoresFila);
            holder.ivImagenPantallaFila = fila.findViewById(R.id.ivImagenPantallaFila);

            fila.setTag(holder);
        }
        else {
            holder = (ViewHolder) fila.getTag();
        }
        // capturamos los ids de cada componente de nuestro layout
        holder.tvOpcionFila.setText(arrayPantallas.get(position).getOpcionFila());
        holder.tvInformacionFila.setText(arrayPantallas.get(position).getInformacionFila());
        holder.tvNumerosColoresFila.setText(arrayPantallas.get(position).getNumerosColoresFila());
        holder.ivImagenPantallaFila.setImageResource(arrayPantallas.get(position).getImagenPantallaFila());

        return fila;
    }
}
