package br.com.gallon.geodata.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PaisDbHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE " + PaisContract.PaisEntry.TABLE_NAME + "(" +
                    PaisContract.PaisEntry._ID + " INTEGER PRIMARY KEY,"+
                    PaisContract.PaisEntry.COLUMN_NAME_NOME + " TEXT," +
                    PaisContract.PaisEntry.COLUMN_NAME_REGIAO + " TEXT," +
                    PaisContract.PaisEntry.COLUMN_NAME_CAPITAL + " TEXT," +
                    PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA + " TEXT," +
                    PaisContract.PaisEntry.COLUMN_NAME_CODIGO3 + " TEXT)";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Paises.db";

    public static final String SQL_DROP_PAIS =
            "DROP TABLE IF EXISTS " + PaisContract.PaisEntry.TABLE_NAME;

    public PaisDbHelper(Context contexto){
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PAIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_CREATE_PAIS);
    }
}
