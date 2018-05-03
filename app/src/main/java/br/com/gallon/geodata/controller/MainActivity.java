package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import br.com.gallon.geodata.R;


public class MainActivity extends Activity {
    public static final String CONTINENTE = "br.usjt.devweb.servicedesk_aula03.MainActivity.continente";
    private Spinner spinContinente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinContinente = findViewById(R.id.continente_selecionado);
    }

    public void listarPaises(View view) {
        String continente = spinContinente.getSelectedItem().toString();
        Intent intent = new Intent(this, ListarPaisesActivity.class);
        intent.putExtra(CONTINENTE, continente);
        startActivity(intent);
    }
}
