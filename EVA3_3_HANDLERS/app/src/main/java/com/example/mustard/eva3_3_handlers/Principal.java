package com.example.mustard.eva3_3_handlers;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //nada de trabajo pesado

            if (msg.what==1){
                int i = (int)msg.obj;
                txtVwDatos.append(i+"-");

            }

        }
    };

    TextView txtVwDatos;
    Thread tHilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        MiHilo mhHilo = new MiHilo();
        Thread tHilo = new Thread(mhHilo);
        tHilo.start();

    }
    class MiHilo implements  Runnable{
        int i = 0;
        public void run (){
            while(true){
                i++;
                try{
                    Message msg = hManejador.obtainMessage(1,i);
                    hManejador.sendMessage(msg);
                    Log.wtf("caca",i+"holis");
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    return;

                }

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tHilo.interrupt();
    }
}
