package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Pais;

import static br.com.gallon.geodata.model.Data.getNomes;
import static br.com.gallon.geodata.model.Data.listarPaises;


public class ListarPaisesActivity extends Activity {
    ArrayList<Pais> paises;
    ListView listView;
    Activity context;
    String continente;
    public static final String PAIS = "br.usjt.devweb.servicedesk_aula03.pais";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises);
        Intent intent = getIntent();
        continente = intent.getStringExtra(MainActivity.CONTINENTE);
        paises = listarPaises(continente);
        ArrayList<String> nomesPaises = getNomes(paises, continente);
        listView = findViewById(R.id.lista_paises);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesPaises);
        listView.setAdapter(adapter);
        context = this;
        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Pais pais = paises.get(position);
                    Intent intent1 = new Intent(context , VisualizarPaisActivity.class);
                    intent1.putExtra(PAIS, pais);
                    startActivity(intent1);
                }
            }
        );
    }


}
