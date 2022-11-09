package com.mobile.projetofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class telaLogin extends AppCompatActivity {

    private TextView text_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //esconde a barra azul da tela
        getSupportActionBar().hide();

        IniciarComponentes();

        text_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cria a intenção de que ao clicar no text de criar cadastro seja direcionado para a tela de cadastro
                Intent intent = new Intent(telaLogin.this,telaCadastro.class);
                startActivity(intent);
            }
        });
    }

    //faz referencia ao id do botão text_cadastro que leva para a próxima tela
    private void IniciarComponentes(){
        text_cadastro = findViewById(R.id.text_cadastro);
    }
}