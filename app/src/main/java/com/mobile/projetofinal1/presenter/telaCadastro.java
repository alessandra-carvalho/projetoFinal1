package com.mobile.projetofinal1.presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.mobile.projetofinal1.R;
import com.mobile.projetofinal1.database.DBUser;
import com.mobile.projetofinal1.model.User;


/* classe responsável por manipulação da activity_tela_cadastro */
public class telaCadastro extends AppCompatActivity {

    private TextView text_cadastro;
    //criando as variaveis
    EditText edit_nome;
    EditText edit_email;
    EditText edit_senha;
    Button bt_cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        getSupportActionBar().hide();

        //faz a ligação com o id de cada objeto da activity
        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        bt_cadastrar = findViewById(R.id.bt_cadastrar);

        /* conexão e gestão do banco de dados */
        DBUser.abrirBanco(this);
        DBUser.abrirOuCriarTabela(this);
        DBUser.fecharDB();

    }

    //metodo inserir registro
    public void inserirRegistro(View v){
        String st_nome, st_email, st_senha;
        st_nome = edit_nome.getText().toString();
        st_email = edit_email.getText().toString();
        st_senha = edit_senha.getText().toString();

        // popular a classe user construtor com os objetos da tela de cadastro
        User objUser = new User(st_nome, st_email, st_senha);

        // chamar a classe DBUser metodo inserir registros passando parametro User e main
        DBUser.inserirRegistro(objUser, this);

        //após fechar e limpar os campos da tela
        edit_nome.setText(null);
        edit_email.setText(null);
        edit_senha.setText(null);


    }

}