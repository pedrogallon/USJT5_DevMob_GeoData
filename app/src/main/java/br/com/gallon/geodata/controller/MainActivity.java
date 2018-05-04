package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Pais;
import br.com.gallon.geodata.model.PaisDb;
import br.com.gallon.geodata.model.PaisNetwork;


public class MainActivity extends Activity {
    public static final String LISTA_PAISES = "br.com.gallon.geodata.controller..MainActivity.ListaPaises";
    private Spinner spinContinente;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        spinContinente = findViewById(R.id.continente_selecionado);
    }

    public void listarPaises(View view) {
        String continente = spinContinente.getSelectedItem().toString();
        if (continente.equals("Todos")) {
            new JSONPaises().execute("https://restcountries.eu/rest/v2/all");
        } else {
            new JSONPaises().execute("https://restcountries.eu/rest/v2/region/" + continente);
        }
    }

    private class JSONPaises extends AsyncTask<String, Void, ArrayList<Pais>> {


        @Override
        protected ArrayList<Pais> doInBackground(String... strings) {

            PaisDb db = new PaisDb(context);
            ArrayList<Pais> paises = db.selecionaPaises();
            if (paises == null || paises.isEmpty()) {
                Log.d("PEDRO","Lista testá vazia");
                try {
                    paises = PaisNetwork.buscarPaises(strings[0]);

                    db.inserePaises(paises);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Log.d("PEDRO","Lista testá preenchida");
            }
            return paises;
        }

        protected void onPostExecute(ArrayList<Pais> paises) {
            Intent intent = new Intent(context, ListarPaisesActivity.class);
            intent.putExtra(LISTA_PAISES, paises);
            startActivity(intent);
        }

    }
}
