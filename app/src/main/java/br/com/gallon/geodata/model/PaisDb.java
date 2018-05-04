package br.com.gallon.geodata.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PaisDb {
    PaisDbHelper dbHelper;

    public PaisDb(Context context){
        dbHelper = new PaisDbHelper(context);
    }

    public void inserePaises(ArrayList<Pais> paises){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

                for(Pais pais:paises){
            ContentValues values = new ContentValues();
            values.put(PaisContract.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());

            db.insert(PaisContract.PaisEntry.TABLE_NAME, null, values);
        }
    }

    public ArrayList<Pais> selecionaPaises(){
        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = { PaisContract.PaisEntry.COLUMN_NAME_NOME,
                PaisContract.PaisEntry.COLUMN_NAME_REGIAO,
                PaisContract.PaisEntry.COLUMN_NAME_CAPITAL,
                PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA,
                PaisContract.PaisEntry.COLUMN_NAME_CODIGO3};
        String ordem = PaisContract.PaisEntry.COLUMN_NAME_NOME;

        Cursor c = db.query(PaisContract.PaisEntry.TABLE_NAME, colunas, null, null,
                ordem, null, null);
        while(c.moveToNext()) {
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_REGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_CODIGO3)));

            paises.add(pais);
        }
        c.close();
        if(paises.size()> 0) {
            return paises;
        } else {
            return new ArrayList<>();
        }
    }
}
