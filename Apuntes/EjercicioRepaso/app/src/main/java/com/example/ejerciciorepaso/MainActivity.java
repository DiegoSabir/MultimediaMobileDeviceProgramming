package com.example.ejerciciorepaso;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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


        llCiclos = findViewById(R.id.llCiclos);
        spCursos = findViewById(R.id.spCursos);
        spCiclos = findViewById(R.id.spCiclos);
        btnGuardar = findViewById(R.id.btnGuardar);
        lvAlumnos = findViewById(R.id.lvAlumnos);
        etNombreApellidos = findViewById(R.id.etNombreApellidos);


        escuchadorCursos();
        escuchadorCiclos();


        createAdapter();


        clickListenerLv();


        registerForContextMenu(lvAlumnos);
    }


    private void createAdapter() {
        // Crea y establece un adaptador personalizado (AdaptadorAlumno) para el ListView lvAlumnos.
        // Toma la lista arrayAlumnos como origen de datos y el diseño R.layout.lista para cada elemento de la lista.
        adaptador = new AdaptadorAlumno(this , R.layout.lista, arrayAlumnos);

        // Establece el adaptador creado en el ListView lvAlumnos, lo que permite mostrar los datos de los alumnos en la interfaz de usuario.
        lvAlumnos.setAdapter(adaptador);
    }


    // Configura un escuchador de clics para el ListView
    private void clickListenerLv() {
        lvAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Cuando se hace clic en un elemento de la lista, se muestra un mensaje emergente (Toast) con la información del alumno seleccionado.
                Toast.makeText(MainActivity.this, arrayAlumnos.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Este método se llama cuando se está creando un menú contextual para el ListView
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        //  Infla el menú contextual desde el archivo XML menu_contextual.xml y establece un encabezado para el menú con el nombre del alumno seleccionado.
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


    //  Este método se llama cuando se selecciona un elemento del menú contextual.
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //Si se selecciona "Eliminar", se elimina el alumno seleccionado de la lista y se actualiza el adaptador
            case R.id.ctx_eliminar:
                arrayAlumnos.remove(selectedLv);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this, "Has eliminado al alumno", Toast.LENGTH_SHORT).show();

            //Si se selecciona "Salir", se muestra un mensaje Toast indicando que se ha salido del menú contextual.
            case R.id.ctx_salir:
                Toast.makeText(this, "Has salido del Menú Contextual", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }


    //Este método configura un escuchador para el Spinner spCiclos
    private void escuchadorCiclos() {
        spCiclos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //Cuando se selecciona un elemento del Spinner, se guarda su valor en la variable ciclo.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ciclo = spCiclos.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    // Este método configura un escuchador para el Spinner
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

                // Obtiene el valor del elemento seleccionado en el Spinner spCursos y lo asigna a la variable curso.
                curso = spCursos.getSelectedItem().toString();

                // Verifica si primero es false. primero es una variable booleana que indica si es la primera vez que se selecciona un curso.
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


    // Este método maneja el clic en el botón de guardar
    public void onClickBtn(View view) {
        switch (view.getId()){
            case R.id.btnGuardar:
                //Verifica si los campos de edición contienen datos válidos llamando al método comprobarEdit()
                if (comprobarEdit()){
                    guardarAlumno();
                }
                break;
        }
    }



    private void guardarAlumno() {
        // Obtiene el nombre del alumno del EditText etNombreApellidos.
        nombre = etNombreApellidos.getText().toString();
        // Crea un nuevo objeto Alumno con los datos ingresados y lo agrega a la lista.
        arrayAlumnos.add(new Alumno(nombre, curso, ciclo));
        // Notifica al adaptador que los datos han cambiado para que actualice la vista del ListView.
        adaptador.notifyDataSetChanged();
    }


    //  Verifica si el campo de edición (etNombreApellidos) contiene datos válidos. Si el campo está vacío
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
}
