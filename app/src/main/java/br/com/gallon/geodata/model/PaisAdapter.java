package br.com.gallon.geodata.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import br.com.gallon.geodata.R;


public class PaisAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pais> paises;

    public PaisAdapter(Context context, ArrayList<Pais> paises){
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int i) {
        return paises.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.adapter_pais, viewGroup, false );


        ImageView img = view.findViewById(R.id.adapter_pais_imagem);
        TextView nome = view.findViewById(R.id.adapter_pais_nome);
        TextView info = view.findViewById(R.id.adapter_pais_info);
        Pais pais = paises.get(i);
        ViewHolder viewHolder = new ViewHolder(img, nome, info);
        view.setTag(viewHolder);

        Drawable drawable = Util.getDrawable(context, paises.get(i).getCodigo3().toLowerCase());
        viewHolder.getImg().setImageDrawable(drawable);
        viewHolder.getNome().setText(pais.getNome());
        viewHolder.getInfo().setText("Região: "+pais.getRegiao()+"  Capital: "+pais.getCapital());

        return view;
    }
}
