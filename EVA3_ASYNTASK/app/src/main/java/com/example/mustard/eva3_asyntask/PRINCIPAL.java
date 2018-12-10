package com.example.mustard.eva3_asyntask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PRINCIPAL extends AppCompatActivity {
    TextView txtVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        Async claseAsync = new Async();
        claseAsync.execute(50, 100);
    }

    ;

    class Async extends AsyncTask<Integer, String, Void> {

        @Override
        protected Void doInBackground(Integer... params) {
            int inicio = params[0];
            int ult = params[1];
            for (; inicio < ult; inicio++) {
                try {
                    Thread.sleep(300);
                    publishProgress(inicio + " - ");
                } catch (Exception e) {
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtVwDatos.append(values[0]);
        }
    }
}