package com.example.pulsaetiqueta;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityV2 extends AppCompatActivity {
    int angulo = 45;

    private ImageView ivEmoticono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_v2);

        ivEmoticono = findViewById(R.id.ivEmoticono);

        /** OPCION 1
        ivEmoticono.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                angulo += 45;
                ivEmoticono.setRotation(angulo);
            }
        });
         */
    }

    //OPCION 2
    public void rotar(View v) {
        ivEmoticono.setRotation(ivEmoticono.getRotation() + angulo);
    }
}
