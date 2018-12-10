package com.example.mustard.eva3_servicios;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    Intent inservcio;
    BroadcastReceiver miBroadcast;
    TextView txtVwTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inservcio = new Intent(this,MiServicio.class);
        miBroadcast = new MiBroadCastReciver();
        IntentFilter ifFiltrarServicios = new IntentFilter("Mis_servicio");
        registerReceiver(miBroadcast,ifFiltrarServicios);
        txtVwTexto = findViewById(R.id.txtVwTexto);
    }
    public void ClickIn (View v){

    }
    public void Clickfin (View v){

    }
    class MiBroadCastReciver extends  BroadcastReceiver{


        @Override
        public void onReceive(Context context, Intent intent) {
            //AQUI EMPIEZA LO CHIDO CON LA ETUQUETA
        }
    }
}
