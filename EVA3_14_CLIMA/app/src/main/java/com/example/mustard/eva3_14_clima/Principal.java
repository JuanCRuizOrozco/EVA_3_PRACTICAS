package com.example.mustard.eva3_14_clima;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Principal extends AppCompatActivity {
    TextView txtVwtexto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        txtVwtexto = findViewById(R.id.txtVwtexto);
    }
    public void click (View v){
        // iniciar la clase conexion.
        new Conexion().execute();

    }
    class Conexion extends AsyncTask<Void, Void, String>{
        final String sLink = "https://samples.openweathermap.org/data/2.5/group?id=524901,703448,2643743&units=metric&appid=b6907d289e10d714a6e88b30761fae22";

        @Override
        protected String doInBackground(Void... voids) {
            //Aqui se hace la conexion.
            String sResu = "";//aqui sale el jason.

            try{
                URL url = new URL(sLink);
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                if (httpCon.getResponseCode()==HttpURLConnection.HTTP_OK){
                    //es como leer un archivo de texto
                    BufferedReader brDatos = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
                    sResu = brDatos.readLine();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return sResu;

        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            //lectura de datos
            JSONArray JCiudades = null;
            if (!s.equals("")){
                try {
                    //cfreamos el objeto jason
                    JSONObject jsDatos = new JSONObject(s);
                    JCiudades = jsDatos.getJSONArray("list");
                    for (int i=0; i<JCiudades.length(); i++){
                        JSONObject jCiudad = JCiudades.getJSONObject(i);
                        txtVwtexto.append("ciudad: "+jCiudad.getString("name"));
                    }
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
        }
    }
}
