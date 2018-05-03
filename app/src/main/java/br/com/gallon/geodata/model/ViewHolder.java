package br.com.gallon.geodata.model;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    ImageView img;
    TextView nome, info;

    public ViewHolder(ImageView img, TextView nome, TextView info) {
        this.img = img;
        this.nome = nome;
        this.info = info;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getInfo() {
        return info;
    }

    public void setInfo(TextView info) {
        this.info = info;
    }
}
