package com.example.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActivityAuxiliar {
    private TextView tvCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCtx = findViewById(R.id.tvCtx);

        //asociar el menú contextual a la TextView
        registerForContextMenu(tvCtx);
    }

    /*
    MENÚ CONTEXTUAL
     */

    //onCreate del Menú contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_contextual, menu);     //Le pasamos el menú que queremos añadir y el menu de ContextMenu del metodo onCreateContextMenu()

    }

    //listener para el menú contextual
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ctx_item1:
                Toast.makeText(this, "Has seleccionado Opción 1 del menú contextual", Toast.LENGTH_SHORT).show();

            case R.id.ctx_item2:
                Toast.makeText(this, "Has seleccionado Opción 2 del menú contextual", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    /*
    MENÚ OPCIONES
     */

    //==========================================================================================================//
    //inflar el menú
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_opciones, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.opc_item1:
                Toast.makeText(this, "Pulsada opción 1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item2:
                Toast.makeText(this, "Pulsada opción 2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item3:
                Toast.makeText(this, "Pulsada opción 3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item4:
                Toast.makeText(this, "Pulsada opción 4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.opc_item5:
                Toast.makeText(this, "Pulsada opción 5", Toast.LENGTH_SHORT).show();
                break;

            case R.id.subitem1:
                Toast.makeText(this, "Pulsado subitem1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.subitem2:
                Toast.makeText(this, "Pulsado subitem2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    public void onClickBtn2(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}