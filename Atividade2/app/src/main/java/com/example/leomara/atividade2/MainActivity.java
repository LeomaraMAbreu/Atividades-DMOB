package com.example.leomara.atividade2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ControllerBanco crud = new ControllerBanco(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.txt_nome);
                EditText numerol = (EditText)findViewById((R.id.txt_leito));
                EditText pressao = (EditText)findViewById(R.id.txt_pressao);
                EditText batimento = (EditText)findViewById(R.id.txt_batimentos);
                EditText temperatura = (EditText)findViewById(R.id.txt_temperatura);
                String nomeString = nome.getText().toString();
                String numerolString = numerol.getText().toString();
                String pressaoString = pressao.getText().toString();
                String batimentoString = batimento.getText().toString();
                String temperaturaString = temperatura.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString,numerolString,pressaoString,batimentoString,temperaturaString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

        Button Listar = (Button)findViewById(R.id.bt_listar);

        Listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ConsultarActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
