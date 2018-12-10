package com.example.mustard.eva3_4_banner_chafa;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView imgBanner;
    boolean destruir = false;
    Handler hManejador = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    int nextView =0;
    Handler message = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch(nextView){
                case 0:
                    imgBanner.setImageResource(R.drawable.cloudy);
                    nextView++;
                    break;
                case 1:
                    imgBanner.setImageResource(R.drawable.rainy);
                    nextView++;
                    break;
                default:
                    imgBanner.setImageResource(R.drawable.sunny);
                    nextView = 0;
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgBanner = findViewById(R.id.imgBanner);

        Thread timer = new Thread(){
            @Override
            public void run(){
                super.run();
                while(true){
                    try{
                        Message msg = message.obtainMessage();
                        message.sendMessage(msg);
                        Thread.sleep(1500);
                        if(destruir)
                            break;
                    }catch(Exception e){}
                }
            }
        };

        timer.start();
    }
    @Override
    protected void onStop() {
        super.onStop();
        destruir = true;
    }


}
