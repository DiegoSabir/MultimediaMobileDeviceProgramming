package com.example.ejercicio16_repaso_v2;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout llCiclos;
    private Spinner spCursos, spCiclos;
    private Button btnGuardar;
    private ListView lvAlumnos;
    private EditText etNombreApellidos;
    private ArrayList<Alumno> arrayAlumnos = new ArrayList<>();
    private String curso = "ESO";
    private String ciclo;
    private String nombre;
    private AdaptadorAlumno adaptador;
    private Alumno selectedLv;
    private boolean primero = false;
    private BaseDeDatos bbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbdd = new BaseDeDatos(this);

        inicializarViews();
        escuchadorCursos();
        escuchadorCiclos();
        createAdapter();
        clickListenerLv();
        registerForContextMenu(lvAlumnos);
    }

    private void inicializarViews() {
        llCiclos = findViewById(R.id.llCiclos);
        spCursos = findViewById(R.id.spCursos);
        spCiclos = findViewById(R.id.spCiclos);
        btnGuardar = findViewById(R.id.btnGuardar);
        lvAlumnos = findViewById(R.id.lvAlumnos);
        etNombreApellidos = findViewById(R.id.etNombreApellidos);
    }

    private void createAdapter() {
        adaptador = new AdaptadorAlumno(this , R.layout.lista, arrayAlumnos);

        lvAlumnos.setAdapter(adaptador);
    }


    private void clickListenerLv() {
        lvAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Alumno alumno = arrayAlumnos.get(position);
                String mensajeDialog = alumno.toString();
                String tituloDialog = "Informacion del alumno";

                ImageView ivAlumnoCurso = view.findViewById(R.id.ivAlumnoCurso);
                Drawable icono = ivAlumnoCurso.getDrawable();

                mostrarDialog(mensajeDialog, tituloDialog, icono);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_contextual, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;

        try{
            selectedLv = (Alumno) lvAlumnos.getAdapter().getItem(info.position);
            nombre = selectedLv.getNombre();
        }
        catch (Exception e){
            Toast.makeText(this, "Error: " + e, Toast.LENGTH_SHORT).show();
        }
        menu.setHeaderTitle(nombre);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ctx_eliminar:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("¿Estás seguro de que deseas eliminar este alumno?");
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        bbdd.borrarAlumno(selectedLv);
                        arrayAlumnos.remove(selectedLv);
                        adaptador.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Alumno eliminado", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
                return true;

            case R.id.ctx_salir:
                Toast.makeText(this, "Has salido del Menú Contextual", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    private void escuchadorCiclos() {
        spCiclos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciclo = spCiclos.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void escuchadorCursos() {
        spCursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spCursos.getSelectedItem().toString().equals("Ciclos")){
                    llCiclos.setVisibility(View.VISIBLE);
                    ciclo = "DAM";
                }
                else {
                    llCiclos.setVisibility(View.GONE);
                    ciclo = "";
                }

                curso = spCursos.getSelectedItem().toString();

                if (!primero){
                    primero = true;
                }
                else {
                    Toast.makeText(MainActivity.this, curso, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:
                if (comprobarEdit()){
                    guardarAlumno();
                }
                break;
        }
    }

    private void guardarAlumno() {
        nombre = etNombreApellidos.getText().toString();
        Alumno alumno = new Alumno(nombre, curso, ciclo);

        // Guardar el alumno en la base de datos
        bbdd.agregarAlumno(alumno);

        // Agregar el alumno a la lista y actualizar la interfaz de usuario
        arrayAlumnos.add(alumno);
        adaptador.notifyDataSetChanged();

        etNombreApellidos.setText("");
    }

    private boolean comprobarEdit() {
        boolean nombreValido = false;
        if (etNombreApellidos.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Introduzca nombre y apellidos", Toast.LENGTH_SHORT).show();
        }
        else {
            nombreValido = true;
        }
        return nombreValido;
    }

    private void mostrarDialog(String mensajeDialog, String tituloDialog, Drawable icono) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage(mensajeDialog)
                .setTitle(tituloDialog)
                .setIcon(icono)
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


}