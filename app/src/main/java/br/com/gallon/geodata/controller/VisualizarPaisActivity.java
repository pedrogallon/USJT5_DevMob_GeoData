package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Pais;

import static br.com.gallon.geodata.controller.ListarPaisesActivity.PAIS;


public class VisualizarPaisActivity extends Activity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_pais);
        txt = findViewById(R.id.detalhes_pais);
        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(PAIS);
        txt.setText(pais.toString());
    }
}
