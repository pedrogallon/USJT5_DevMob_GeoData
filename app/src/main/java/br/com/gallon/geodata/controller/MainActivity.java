package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Data;
import br.com.gallon.geodata.model.Pais;


public class MainActivity extends Activity {
    public static final String LISTA_PAISES = "br.usjt.devweb.servicedesk_aula03.MainActivity.ListaPaises";
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

        Intent intent = new Intent(context, ListarPaisesActivity.class);
        intent.putExtra(LISTA_PAISES, Data.listarPaises(continente));
        startActivity(intent);

    }

}
