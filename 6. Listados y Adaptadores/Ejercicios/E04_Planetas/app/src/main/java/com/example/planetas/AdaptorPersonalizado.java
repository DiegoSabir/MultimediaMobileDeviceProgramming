package com.example.planetas;

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

public class AdaptorPersonalizado extends ArrayAdapter {
    private Activity context;
    private String[] arrayPlanetas;
    private int[] arrayIdPlanetas;
    private String[] arrayDatosPlanetas;
    private int layoutPersonalizado;
    public AdaptorPersonalizado(@NonNull Activity context, int layoutPersonalizado, String[] arrayPlanetas, int[] arrayIdPlanetas, String[] arrayDatosPlanetas) {
        super(context, layoutPersonalizado, arrayPlanetas);
        this.context = context;
        this.arrayPlanetas = arrayPlanetas;
        this.arrayIdPlanetas = arrayIdPlanetas;
        this.arrayDatosPlanetas = arrayDatosPlanetas;
        this.layoutPersonalizado = layoutPersonalizado;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View fila = layoutInflater.inflate(layoutPersonalizado,null);
        TextView tvPlaneta=fila.findViewById(R.id.tvPlaneta);
        ImageView ivPlaneta=fila.findViewById(R.id.ivPlaneta);
        TextView tvDataPlaneta=fila.findViewById(R.id.tvDatosPlaneta);

        tvPlaneta.setText(arrayPlanetas[position]);
        ivPlaneta.setImageResource(arrayIdPlanetas[position]);
        tvDataPlaneta.setText(arrayDatosPlanetas[position]);

        return fila;
    }
}
