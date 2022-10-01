package com.example.navegaoactivities.listasexemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Exemplo3Activity extends AppCompatActivity {

    // Atributos relativos aos objetos gráficos
    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtTelefone;
    private Button btnAdicionar;
    private ListView lista;

    // ArrayList com os contatos
    private ArrayList<Contato> contatos = new ArrayList<Contato>();

    // Adapter da lista
    private AdapterContatos adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemplo3);

        // Ligando os atributos com os IDs dos objetos na interface
        this.txtNome = findViewById(R.id.txtNome);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.txtTelefone = findViewById(R.id.txtTelefone);
        this.btnAdicionar = findViewById(R.id.btnAdicionar);
        this.lista = findViewById(R.id.lista);
        // Criar um adapter para a a lista
        this.adaptador = new AdapterContatos(this, this.contatos);
        // Configurar a lista para utilizar o objeto adaptador
        this.lista.setAdapter(adaptador);
        // Definindo o escutador do botão
        this.btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pegando os dados do formulário
                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String telefone = txtTelefone.getText().toString();
                // Criando o objeto contato
                Contato contato = new Contato(nome, email, telefone);
                // Adicionando o contato no ArrayList
                contatos.add(contato);
                // Avisando o adapter que um nome contato foi inserido
                adaptador.notifyDataSetChanged();
                // Limpando a interface para a pŕoxima digitação
                txtNome.setText("");
                txtEmail.setText("");
                txtTelefone.setText("");
            }
        });
    }
}


