package com.example.mustard.eva3_servico;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {
    Button btnElboton;
    Intent inServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnElboton = findViewById(R.id.btndetener);
        inServicio = new Intent(this, MiServicio.class);
        startService(inServicio);

    }
    public void onClic(View v){
        try {
            stopService(inServicio);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
