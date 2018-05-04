package br.com.gallon.geodata.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.gallon.geodata.R;
import br.com.gallon.geodata.model.Pais;
import br.com.gallon.geodata.model.Util;

import static br.com.gallon.geodata.controller.ListarPaisesActivity.PAIS;

public class VisualizarPaisActivity extends Activity {
    ImageView bandeira;
    TextView nome;
    TextView regiao;
    TextView capital;
    TextView codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_pais);
        nome = findViewById(R.id.visualizar_nome);
        regiao = findViewById(R.id.visualizar_regiao);
        capital = findViewById(R.id.visualizar_capital);
        codigo = findViewById(R.id.visualizar_codigo);
        bandeira = findViewById(R.id.visualizar_bandeira);

        Intent intent = getIntent();
        Pais pais = (Pais) intent.getSerializableExtra(PAIS);
        nome.setText(pais.getNome());
        regiao.setText("Região: "+pais.getRegiao());
        capital.setText("Capital: "+pais.getCapital());
        codigo.setText("Cód.3: "+pais.getCodigo3());
        Drawable drawable = Util.getDrawable(this, pais.getCodigo3().toLowerCase());
        bandeira.setImageDrawable(drawable);
    }
}
