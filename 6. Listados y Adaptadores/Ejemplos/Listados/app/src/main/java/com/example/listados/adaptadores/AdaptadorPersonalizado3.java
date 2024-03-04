package com.example.listados.adaptadores;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.example.listados.Planeta;
import com.example.listados.R;

import java.util.ArrayList;

public class AdaptadorPersonalizado3 extends ArrayAdapter {

    private Activity activity;
    private ArrayList<Planeta> arrayPlanetas;
    private int layout_personalizado;

    public AdaptadorPersonalizado3(@NonNull Activity activity, int layout_personalizado, ArrayList arrayPlanetas) {
        super(activity, layout_personalizado, arrayPlanetas);
        this.layout_personalizado = layout_personalizado;
        this.activity = activity;
        this.arrayPlanetas = arrayPlanetas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;
        ViewHolder holder;

        if (fila == null){
            LayoutInflater inflater = activity.getLayoutInflater();

            fila = inflater.inflate(layout_personalizado, null);

            holder = new ViewHolder();
            holder.tvPlanetas = fila.findViewById(R.id.tvPlaneta);
            holder.imgPlaneta = fila.findViewById(R.id.imgPlaneta);

            fila.setTag(holder);
        }
        else {
            holder = (ViewHolder) fila.getTag();
        }

        // capturamos los ids de cada componente de nuestro layout
        holder.tvPlanetas.setText(arrayPlanetas.get(position).getNombrePlaneta());
        holder.imgPlaneta.setImageResource(arrayPlanetas.get(position).getIdFotoPlaneta());
        return fila;
    }

    static class ViewHolder {
        TextView tvPlanetas;
        ImageView imgPlaneta;
    }
}
