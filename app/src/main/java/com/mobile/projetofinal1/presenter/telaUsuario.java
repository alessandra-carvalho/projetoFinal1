package com.mobile.projetofinal1.presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mobile.projetofinal1.R;

public class telaUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);

        //esconde o cabeçalho do projeto***
        getSupportActionBar().hide();
    }
}