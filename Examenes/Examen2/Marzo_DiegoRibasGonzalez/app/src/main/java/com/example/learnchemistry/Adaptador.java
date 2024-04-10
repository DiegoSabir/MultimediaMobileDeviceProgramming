package com.example.learnchemistry;

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
    private Activity activity;
    private int layout_personalizado;
    private ArrayList<Quimico> arrayQuimicos;

    public Adaptador(@NonNull Activity activity, int layout_personalizado, ArrayList arrayQuimicos) {
        super(activity, layout_personalizado, arrayQuimicos);

        this.activity = activity;
        this.layout_personalizado = layout_personalizado;
        this.arrayQuimicos = arrayQuimicos;
    }

    //ASOCIA UN LAYOUT PERSONALIZADO A LA VIEW
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View fila = convertView;
        ViewHolder holder;

        if (fila == null){
            LayoutInflater inflater = activity.getLayoutInflater();

            fila = inflater.inflate(layout_personalizado, null);

            holder = new ViewHolder();
            holder.tvList = fila.findViewById(R.id.tvList);
            holder.ivList = fila.findViewById(R.id.ivList);

            fila.setTag(holder);
        }
        else {
            holder = (ViewHolder) fila.getTag();
        }

        holder.tvList.setText(arrayQuimicos.get(position).getQuimico());

        holder.ivList.setImageResource(arrayQuimicos.get(position).getIdQuimico());

        return fila;
    }

    //ESTE VIEWHOLDER VALE PARA AHORRAR RECURSOS
    static class ViewHolder {
        TextView tvList;
        ImageView ivList;
    }
}
