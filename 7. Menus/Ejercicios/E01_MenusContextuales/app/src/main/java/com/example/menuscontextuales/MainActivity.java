package com.example.menuscontextuales;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tvHello);


        registerForContextMenu(tvHello);
    }

    //inflar el menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if (v.getId() == R.id.tvHello){
            inflater.inflate(R.menu.menu_contextual, menu); //asociado a la textView
        }
        else if (v.getId() == R.id.imageView){
            inflater.inflate(R.menu.menu_contextual_imagen, menu);//asociado a la imageView
        }
    }

    //listener para el menu de opciones
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.opc_ctx_item1:
                Toast.makeText(this, "Seleccionado", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.opc_ctx_item2:
                Toast.makeText(this, "Seleccionado", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }
}