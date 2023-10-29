package com.example.pulsaetiqueta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView ivEmoticono;
    float angulo = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivEmoticono = findViewById(R.id.ivEmoticono);

        ivEmoticono.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                angulo += 45;
                ivEmoticono.setRotation(angulo);
            }
        });
    }
}