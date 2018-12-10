package com.example.mustard.eva3_2_hiloss;

import android.util.Log;

public class MiHilo extends Thread {
    @Override
    public void run() {
        super.run();
        while (true){
             try{
                 Log.wtf("hilo","holis");
                 Thread.sleep(500);
             }catch (Exception e){
                 e.printStackTrace();
             }
        }
    }
}
