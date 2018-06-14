package com.example.leomara.atividade2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ControllerBanco {

    private SQLiteDatabase db;
    private CriarBanco bancopacientes;

    public ControllerBanco(Context context) { bancopacientes = new CriarBanco(context); }

    public String insereDado(String nome, String numerol, String pressao, String batimento, String temperatura) {
        ContentValues valores;
        long resultado;

        db = bancopacientes.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBanco.NOME, nome);
        valores.put(CriarBanco.NUMERO, numerol);
        valores.put(CriarBanco.PRESSAO, pressao);
        valores.put(CriarBanco.BATIMENTO, batimento);
        valores.put(CriarBanco.TEMPERATURA, temperatura);

        resultado = db.insert(CriarBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso!";

    }

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {bancopacientes.ID, bancopacientes.NOME};
        db = bancopacientes.getReadableDatabase();
        cursor = db.query(bancopacientes.TABELA, campos, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos = {bancopacientes.ID, bancopacientes.NOME, bancopacientes.NUMERO, bancopacientes.PRESSAO,
                bancopacientes.BATIMENTO, bancopacientes.TEMPERATURA};
        String where = CriarBanco.ID + "=" + id;
        db = bancopacientes.getReadableDatabase();
        cursor = db.query(CriarBanco.TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


}
