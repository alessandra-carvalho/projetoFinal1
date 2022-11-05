package com.mobile.projetofinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class telaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);

        //esconde o cabeçalho do projeto
        getSupportActionBar().hide();
    }
}