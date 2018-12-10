package com.example.mustard.eva3_2_hiloss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    TextView txtVwHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwHello = findViewById(R.id.txtTwHello);

       Runnable rHilo = new Runnable() {
           @Override
           public void run() {
               while (true){
                   try {
                       txtVwHello.setText("Hola");
                       Thread.sleep(500);
                   }catch(InterruptedException e){
                       e.printStackTrace();
                   }
               }

           }
       } ;

        MiHilo mhPerpetuo = new MiHilo();
        //mhPerpetuo.run();//Esta madre lo traba.
        mhPerpetuo.start();//Genera trabajo en segundo plano.

    }

}
