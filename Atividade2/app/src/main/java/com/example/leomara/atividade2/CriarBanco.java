package com.example.leomara.atividade2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "Bancopaciente.db";
    public static final String TABELA = "pacientes";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String NUMERO = "numerol";
    public static final String PRESSAO = "pressao";
    public static final String BATIMENTO = "batimento";
    public static final String TEMPERATURA = "temperatura";
    private static final int VERSAO = 1;

    public CriarBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"(" + ID
                + " integer primary key autoincrement,"
                + NOME + " text," + NUMERO
                + " text," + PRESSAO + " text,"
                + BATIMENTO + " text, "
                + TEMPERATURA + " text" +")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
