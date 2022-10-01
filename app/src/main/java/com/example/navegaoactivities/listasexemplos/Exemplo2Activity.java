package com.example.navegaoactivities.listasexemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Exemplo2Activity extends AppCompatActivity {

    // Atributos relativos aos objetos gráficos
    private EditText txtTexto;
    private Button btnAdicionar;
    private ListView lista;

    // ArrayList com as strings
    private ArrayList<String> textos = new ArrayList<String>();

    // Adapter da lista
    private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo2);

        // Ligando os atributos com os IDs dos objetos na interface
        this.txtTexto = findViewById(R.id.txtTexto);
        this.btnAdicionar = findViewById(R.id.btnAdicionar);
        this.lista = findViewById(R.id.lista);

        // Criar um adapter para a a lista
        this.adaptador = new ArrayAdapter<String>(
                this,                        // Contexto da activity
                android.R.layout.simple_list_item_1, // O desenho de item já pronto
                android.R.id.text1,                  // O ID do TextView dentro do item
                this.textos                          // O ArrayList com as strings a serem exibidas
        );

        // Configurar a lista para utilizar o objeto adaptador
        this.lista.setAdapter(adaptador);

        // Definindo o escutador do botão
        this.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pega o texto difitado na caixa
                String t = txtTexto.getText().toString();
                // Adiciona no ArrayList
                textos.add(t);
                // Avisando o adapter que uma nova string foi inserida
                adaptador.notifyDataSetChanged();
                // Limpar texto escrito na caixa
                txtTexto.setText("");
            }
        });

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
            Toast.makeText(Exemplo2Activity.this, "Clique comum: " + textos.get(i), Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            // Remover o item de índice i do ArrayList
            textos.remove(i);
            // Avisar o adapter que o ArrayList mudou
            adaptador.notifyDataSetChanged();
            // Mensagem informativa
            Toast.makeText(Exemplo2Activity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            // Retornar true, indicando que o evento foi tratado.
            // Se retornar false, o clique comum também será tratado em seguida
            return true;
        }
    }
}





