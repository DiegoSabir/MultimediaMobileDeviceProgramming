package com.example.ejercicio19_viewbinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ejercicio19_viewbinding.databinding.ListaBinding; // Importar la clase de ViewBinding
import java.util.ArrayList;

public class AdaptadorAlumno extends ArrayAdapter<Alumno> {
    private Activity activity;

    public AdaptadorAlumno(Activity activity, ArrayList<Alumno> arrayAlumnos) {
        super(activity, 0, arrayAlumnos);
        this.activity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ListaBinding binding;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(activity);
            binding = ListaBinding.inflate(inflater, parent, false); // Inflar el diseño con ViewBinding
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ListaBinding) convertView.getTag();
        }

        Alumno alumno = getItem(position);
        if (alumno != null) {
            binding.tvNombreAlumno.setText(alumno.getNombre().toUpperCase());
            binding.tvCurso.setText(alumno.getCurso());
            binding.tvCiclo.setText(alumno.getCiclo());
            // Resto del código
        }

        return convertView;
    }
}
