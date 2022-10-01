package com.example.navegaoactivities.listasexemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Exemplo12Activity extends AppCompatActivity {

    // Atributos referentes aos objetos da interface
    private ListView lista;
    // Atributo com os textos a serem exibidos na lista
    private ArrayList<String> textos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo1);

        // Lingando o atributo lista
        this.lista = findViewById(R.id.lista);
        // Colocando vários textos no ArrayList
        String[] t = {"um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove",
                "dez", "onze", "doze", "treze", "quatorze", "quize", "dezesseis", "dezesete",
                "dezoito", "dezenove", "vinte", "vinte e um", "vinte e dois", "vinte e três",
                "vinte e quatro", "vinte e cinco", "vinte e seis", "vinte e sete",
                "vinte e oito", "vinte e nove", "trinta"};
        // Coloca todos as strings do vetor t como elementos do ArrayList textos
        this.textos.addAll(Arrays.asList(t));


        // Criar um adapter para a a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                this,                        // Contexto da activity
                android.R.layout.simple_list_item_1, // O desenho de item já pronto
                android.R.id.text1,                  // O ID do TextView dentro do item
                this.textos                          // O ArrayList com as strings a serem exibidas
        );

        // Configurar a lista para utilizar o objeto adaptador
        this.lista.setAdapter(adaptador);

        // Configurar a lista com o escutador de cliques comuns
        this.lista.setOnItemClickListener(new EscutadorLista());

        // Configurar a lista para aceitar cliques longos
        this.lista.setLongClickable(true);

        // Configurar a lista com o escutador de clique longo
        this.lista.setOnItemLongClickListener(new EscutadorLista());
    }

    private class EscutadorLista implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // O parâmetro i é o número do item clicado
            // Os números dos itens iniciam-se em 0 (zero)
            // É o mesmo índice do elemento no ArrayList com os dados
            Toast.makeText(Exemplo12Activity.this, "Clique comum: " + textos.get(i), Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            // O parâmetro i é o número do item clicado
            // Os números dos itens iniciam-se em 0 (zero)
            // É o mesmo índice do elemento no ArrayList com os dados
            Toast.makeText(Exemplo12Activity.this, "Clique longo: " + textos.get(i), Toast.LENGTH_SHORT).show();

            // Retornar true, indicando que o evento foi tratado.
            // Se retornar false, o clique comum também será tratado em seguida
            return true;
        }
    }
}


