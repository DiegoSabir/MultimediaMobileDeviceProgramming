package com.example.ejercicio14_repaso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                mostrarDialog(mensajeDialog, tituloDialog);
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
                arrayAlumnos.remove(selectedLv);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this, "Has eliminado al alumno", Toast.LENGTH_SHORT).show();

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
        arrayAlumnos.add(new Alumno(nombre, curso, ciclo));
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

    private void mostrarDialog(String mensajeDialog, String tituloDialog) {
        AlertDialog.Builder ventana = new AlertDialog.Builder(this);
        ventana.setMessage(mensajeDialog)
                .setTitle(tituloDialog)
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


}