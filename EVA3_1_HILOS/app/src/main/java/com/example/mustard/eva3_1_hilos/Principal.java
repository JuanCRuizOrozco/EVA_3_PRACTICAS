package com.example.mustard.eva3_1_hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Principal extends AppCompatActivity {

    // Runnble
    Runnable rMiHilo = new Runnable() {
        @Override
        public void run() {
            for (int i =0; i<20; i++){
                Log.wtf("Runnable",i+" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //runable (interfaz) hilo(Clase)
        //los runnables necesitan un objeto Thread para iniciarce
        Thread tHilo =  new Thread(rMiHilo);
        tHilo.start();
        miHilo tMihilo = new miHilo();
        tMihilo.start();

    }
    class miHilo extends Thread{
        // pertenece a la clase principal


        @Override
        public void run() {
            super.run();
            for (int i =0; i<20; i++){
                Log.wtf("Thread",i+" ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
