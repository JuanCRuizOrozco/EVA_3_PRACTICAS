package com.example.mustard.eva3_servico;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MiServicio extends Service {
    public MiServicio() {
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("SERVICIO","ON CREATE");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("SERVICIO","ON START");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("SERVICIO","ON DESTROY");
    }
}
