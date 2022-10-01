package com.example.navegaoactivities.listasexemplos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnExemplo11;
    private Button btnExemplo12;
    private Button btnExemplo2;
    private Button btnExemplo3;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnExemplo11 = findViewById(R.id.btnExemplo11);
        this.btnExemplo12 = findViewById(R.id.btnExemplo12);
        this.btnExemplo2 = findViewById(R.id.btnExemplo2);
        this.btnExemplo3 = findViewById(R.id.btnExemplo3);
        this.btnSair = findViewById(R.id.btnSair);

        this.btnExemplo11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Exemplo11Activity.class);
                startActivity(i);
            }
        });

        this.btnExemplo12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Exemplo12Activity.class);
                startActivity(i);
            }
        });

        this.btnExemplo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Exemplo2Activity.class);
                startActivity(i);
            }
        });

        this.btnExemplo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Exemplo3Activity.class);
                startActivity(i);
            }
        });

        this.btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}


