package com.example.ejerciciorepaso;

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

public class AdaptadorAlumno extends ArrayAdapter {
    private Activity activity;
    private ArrayList<Alumno> arrayAlumnos;
    private int layoutPersonalizado;

    public AdaptadorAlumno(@NonNull Activity activity, int layoutPersonalizado, ArrayList<Alumno> arrayAlumnos) {
        super(activity, layoutPersonalizado, arrayAlumnos);
        this.activity = activity;
        this.arrayAlumnos = arrayAlumnos;
        this.layoutPersonalizado = layoutPersonalizado;
    }


    // Método getView para inflar las vistas personalizadas en el ListView
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View fila = convertView;
        ViewHolder holder;

        // Si la vista no está siendo reciclada, inflar la vista personalizada
        if (fila == null){
            LayoutInflater inflater = activity.getLayoutInflater();

            fila = inflater.inflate(layoutPersonalizado, null);

            // Inicializar el objeto ViewHolder y asignar referencias a los elementos de la vista
            holder = new ViewHolder();
            holder.tvNombreAlumno = fila.findViewById(R.id.tvNombreAlumno);
            holder.tvCurso = fila.findViewById(R.id.tvCurso);
            holder.tvCiclo = fila.findViewById(R.id.tvCiclo);
            holder.ivAlumnoCurso = fila.findViewById(R.id.ivAlumnoCurso);

            // Establecer el objeto ViewHolder como una etiqueta de la vista
            fila.setTag(holder);
        }

        else {
            // Si la vista está siendo reciclada, obtener el objeto ViewHolder de la etiqueta de la vista
            holder = (ViewHolder) fila.getTag();
        }

        // Obtener los datos del alumno en la posición actual y establecerlos en los elementos de la vista
        holder.tvNombreAlumno.setText(arrayAlumnos.get(position).getNombre().toUpperCase());
        holder.tvCurso.setText(arrayAlumnos.get(position).getCurso());
        holder.tvCiclo.setText(arrayAlumnos.get(position).getCiclo());


        // Según el curso del alumno, establecer una imagen diferente para ivAlumnoCurso
        if (arrayAlumnos.get(position).getCurso().equals("ESO")){
            holder.ivAlumnoCurso.setImageResource(R.drawable.eso);
        }
        else if (arrayAlumnos.get(position).getCurso().equals("Bach.")) {
            holder.ivAlumnoCurso.setImageResource(R.drawable.bach);
        }
        else {
            holder.ivAlumnoCurso.setImageResource(R.drawable.ciclo);
        }

        // Devolver la vista personalizada
        return fila;
    }


    // Clase ViewHolder para contener las referencias a los elementos de la vista personalizada
    static class ViewHolder{
        TextView tvNombreAlumno;
        TextView tvCurso;
        TextView tvCiclo;
        ImageView ivAlumnoCurso;
    }
}
