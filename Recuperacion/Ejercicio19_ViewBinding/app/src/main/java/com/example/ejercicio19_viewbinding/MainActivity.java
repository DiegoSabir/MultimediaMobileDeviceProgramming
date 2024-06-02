package com.example.ejercicio19_viewbinding;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ejercicio19_viewbinding.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AdaptadorAlumno adaptador;
    private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        createAdapter();
    }

    private void createAdapter() {
        adaptador = new AdaptadorAlumno(this, arrayAlumnos);
        binding.lvAlumnos.setAdapter(adaptador);
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.btnGuardar:
                if (comprobarEdit()) {
                    guardarAlumno();
                }
                break;
        }
    }

    private void guardarAlumno() {
        String nombre = binding.etNombreApellidos.getText().toString();
        String curso = binding.spCursos.getSelectedItem().toString();
        String ciclo = binding.spCiclos.getSelectedItem().toString();

        arrayAlumnos.add(new Alumno(nombre, curso, ciclo));
        adaptador.notifyDataSetChanged();
        binding.etNombreApellidos.setText("");
    }

    private boolean comprobarEdit() {
        boolean nombreValido = false;
        if (binding.etNombreApellidos.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Introduzca nombre y apellidos", Toast.LENGTH_SHORT).show();
        } else {
            nombreValido = true;
        }
        return nombreValido;
    }
}