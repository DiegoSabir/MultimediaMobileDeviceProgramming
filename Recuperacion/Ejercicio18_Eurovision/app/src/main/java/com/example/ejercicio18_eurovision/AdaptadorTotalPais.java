package com.example.ejercicio18_eurovision;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorTotalPais extends ArrayAdapter<Eurovision> {
    private Context context;
    private List<Eurovision> listaResultados;

    private static class ViewHolder {
        TextView tvPais,tvTotalVotos;
    }

    public AdaptadorTotalPais(Context context, List<Eurovision> listaResultados) {
        super(context, R.layout.activity_adaptador_total_pais, listaResultados);
        this.context = context;
        this.listaResultados = listaResultados;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_adaptador_total_pais, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvPais = convertView.findViewById(R.id.tvPaisadaptador);
            viewHolder.tvTotalVotos=convertView.findViewById(R.id.tvTotalVotosadaptador);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Eurovision resultado = listaResultados.get(position);
        viewHolder.tvPais.setText(resultado.getPais());
        viewHolder.tvTotalVotos.setText(String.valueOf(resultado.getVotosJurado()+resultado.getVotosAudiencia()));

        return convertView;
    }
}
