package com.example.mustard.eva3_6_handler_post;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwEt;
    Handler hManejador = new Handler();
    Runnable rHeavyMetal = new Runnable() {
        @Override
        public void run() {
            while (true){
                hManejador.post(rPop);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    };
    int iNUm = 1;
    Runnable rPop = new Runnable() {
        @Override
        public void run() {
            txtVwEt.append((iNUm++)+"-");

        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread Hilo = new  Thread(rHeavyMetal);
        txtVwEt = findViewById(R.id.txtVwEt);
        Hilo.start();
    }
}
