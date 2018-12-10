package com.example.mustard.eva3_13_mediaplayer_servicios;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.mustard.eva3_13_mediaplayer_servicios.R;

public class ServicioPlayer extends Service {
    MediaPlayer mpReproductor= null;
    @Override
    public void onCreate() {
        super.onCreate();
        mpReproductor = MediaPlayer.create(getApplicationContext(), R.raw.cancion);

    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mpReproductor != null){
            mpReproductor.start();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpReproductor !=null){
            mpReproductor.stop();
            mpReproductor.release();
        }
    }


    public  ServicioPlayer (){

    }
    @Override
    public IBinder onBind(Intent intent) {
        return  null;

        //throw new UnsupportedOperationException("Not yet implemented");
    }

}
