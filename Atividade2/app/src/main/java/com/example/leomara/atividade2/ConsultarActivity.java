package com.example.leomara.atividade2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class ConsultarActivity extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Cursor cursor;
        setContentView(R.layout.activity_consulta);

        ControllerBanco crud = new ControllerBanco(getBaseContext());
        cursor = crud.carregaDados();

        final String[] nomeCampos = new String[]{CriarBanco.ID, CriarBanco.NOME};
        int[] idViews = new int[]{R.id.txt_nome, R.id.txt_leito, R.id.txt_pressao, R.id.txt_batimentos, R.id.txt_temperatura};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);


    }

}
