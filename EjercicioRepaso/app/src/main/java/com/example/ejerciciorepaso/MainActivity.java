package com.example.ejerciciorepaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner spCursos;
    private Spinner spCiclos;
    private ArrayAdapter<CharSequence> adaptadorCursos;
    private ArrayAdapter<CharSequence> adaptadorCiclos;
    private EditText etNombreApellidos;
    private Button btnGuardar;
    private ListView lvAlumnos;
    private ArrayAdapter<String> alumnosAdapter;
    private List<String> listaAlumnos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCursos = findViewById(R.id.spCursos);
        spCiclos = findViewById(R.id.spCiclos);
        etNombreApellidos = findViewById(R.id.etNombreApellidos);
        btnGuardar = findViewById(R.id.btnGuardar);
        lvAlumnos = findViewById(R.id.lvAlumnos);


        adaptadorCursos = ArrayAdapter.createFromResource(this, R.array.cursos, android.R.layout.simple_spinner_item);
        adaptadorCursos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCursos.setAdapter(adaptadorCursos);


        adaptadorCiclos = ArrayAdapter.createFromResource(this, R.array.ciclos, android.R.layout.simple_spinner_item);
        adaptadorCiclos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiclos.setAdapter(adaptadorCiclos);
        spCiclos.setVisibility(View.GONE); // Ocultar el Spinner de ciclos inicialmente


        spCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCurso = parent.getItemAtPosition(position).toString();
                if (selectedCurso.equals("Ciclos")) {
                    spCiclos.setVisibility(View.VISIBLE); // Mostrar el Spinner de ciclos si se selecciona "Ciclos"
                }
                else {
                    spCiclos.setVisibility(View.GONE); // Ocultar el Spinner de ciclos en caso contrario
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se necesita ninguna acción si no se selecciona nada en el Spinner de cursos
            }
        });
        // Inicializar lista de alumnos
        listaAlumnos = new ArrayList<>();

        // Inicializar adaptador para la lista de alumnos
        alumnosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaAlumnos);
        lvAlumnos.setAdapter(alumnosAdapter);

        // Establecer el clic del botón Guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreAlumno = etNombreApellidos.getText().toString().trim();
                if (!nombreAlumno.isEmpty()) {
                    listaAlumnos.add(nombreAlumno);
                    alumnosAdapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                    etNombreApellidos.setText(""); // Limpiar el EditText después de guardar
                }
                else {
                    Toast.makeText(MainActivity.this, "Introduzca el nombre del alumno", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
