package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Pais;
import br.com.gallon.geodata.model.PaisAdapter;

import static br.com.gallon.geodata.controller.MainActivity.LISTA_PAISES;


public class ListarPaisesActivity extends Activity {
    ArrayList<Pais> paises;
    ListView listView;
    Activity context;
    public static final String PAIS = "br.com.gallon.geodata.controller.ListarPaisesActivity.pais";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paises);
        paises = (ArrayList<Pais>) getIntent().getSerializableExtra(LISTA_PAISES);
        listView = findViewById(R.id.lista_paises);
        PaisAdapter adapter = new PaisAdapter(this, paises);
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
