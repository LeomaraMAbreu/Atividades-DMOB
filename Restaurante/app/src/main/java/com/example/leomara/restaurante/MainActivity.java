package com.example.leomara.restaurante;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;




import static com.example.leomara.restaurante.R.id.action_bar_title;

public class MainActivity extends AppCompatActivity {


    private Button bt_calcular;
    private EditText edt_consumo;
    private EditText edt_couvert_artistico;
    private EditText edt_dividir;
    private EditText edt_servico;
    private EditText edt_conta_total;
    private EditText edt_valor_pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt_calcular = (Button) findViewById(R.id.bt_calcular);
        edt_consumo = (EditText) findViewById(R.id.edt_consumo);
        edt_couvert_artistico = (EditText) findViewById(R.id.edt_couvert_artistico);
        edt_dividir = (EditText) findViewById(R.id.edt_dividir);
        edt_servico = (EditText) findViewById(R.id.edt_servico);
        edt_conta_total = (EditText) findViewById(R.id.edt_conta_total);
        edt_valor_pessoa = (EditText) findViewById(R.id.edt_valor_pessoa);

        bt_calcular.setOnClickListener(bt_calcularListener);

    }


    OnClickListener bt_calcularListener = new OnClickListener() {
        @Override
        public void onClick(View v) {


            double consumo_total = Double.parseDouble(edt_consumo.getText().toString());
            double couvert_artistico = Double.parseDouble(edt_couvert_artistico.getText().toString());
            double dividir = Double.parseDouble(edt_dividir.getText().toString());
            double taxa_servico = (consumo_total*0.10);
            double conta_total = (consumo_total+couvert_artistico+taxa_servico);
            double valor_pessoa = (conta_total/dividir);

            edt_servico.setText(String.format("%.2f", taxa_servico));
            edt_conta_total.setText(String.format("%.2f", conta_total));
            edt_valor_pessoa.setText(String.format("%.2f", valor_pessoa));

        }
    };


}