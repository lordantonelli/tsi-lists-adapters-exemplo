package com.example.navegaoactivities.listasexemplos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContatos extends ArrayAdapter<Contato> {

    // Contexto
    private Context context;
    // ArrayList de objetos do tipo contato
    private ArrayList<Contato> contatos;

    public AdapterContatos(Context context, ArrayList<Contato> contatos) {
        // Chamada ao construtor da super classe
        super(context, R.layout.item_lista, contatos);
        // Guarda o contexto no atributo correspondente
        this.context = context;
        // Guarda o ArrayList com os itens no atributo correspondente
        this.contatos = contatos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recupera um objeto "inflador" de layouts
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        // "Inflando" o XML do item da lista, gerando sua visualização (view)
        View itemView = li.inflate(R.layout.item_lista, parent, false);
        //Pegando os objetos gráficos dentro do XML do item da lista
        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblEmail = itemView.findViewById(R.id.lblEmail);
        TextView lblTelefone = itemView.findViewById(R.id.lblTelefone);
        // Colocando dados neste item
        // O objeto está no índice "position"
        lblNome.setText(this.contatos.get(position).getNome());
        lblEmail.setText(this.contatos.get(position).getEmail());
        lblTelefone.setText(this.contatos.get(position).getTelefone());
        // A view do item da lista está montada e é só devolver
        return itemView;
    }

}


