package com.example.ejercicio13_listas_v5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
public class AdaptadorPadding extends ArrayAdapter  {
    private Activity context;
    private ArrayList<Padding> arrayPaddings;
    private int layoutPersonalizadoPadding;

    public AdaptadorPadding(@NonNull Activity context, int layoutPersonalizadoPadding, ArrayList arrayPaddings) {
        super(context, layoutPersonalizadoPadding, arrayPaddings);
        this.context = context;
        this.arrayPaddings = arrayPaddings;
        this.layoutPersonalizadoPadding = layoutPersonalizadoPadding;
    }

    static class ViewHolder {
        TextView tvOpcionPaddingFila;
        ImageView ivImagenPaddingFila;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;
        AdaptadorPadding.ViewHolder holder;

        if (fila == null){
            LayoutInflater inflater = context.getLayoutInflater();

            fila = inflater.inflate(layoutPersonalizadoPadding, null);

            holder = new AdaptadorPadding.ViewHolder();
            holder.tvOpcionPaddingFila = fila.findViewById(R.id.tvOpcionPaddingFila);
            holder.ivImagenPaddingFila = fila.findViewById(R.id.ivImagenPaddingFila);

            fila.setTag(holder);
        }
        else {
            holder = (AdaptadorPadding.ViewHolder) fila.getTag();
        }
        // capturamos los ids de cada componente de nuestro layout
        holder.tvOpcionPaddingFila.setText(arrayPaddings.get(position).getOpcionPaddingFila());
        holder.ivImagenPaddingFila.setImageResource(arrayPaddings.get(position).getImagenPaddingFila());

        return fila;
    }
}
