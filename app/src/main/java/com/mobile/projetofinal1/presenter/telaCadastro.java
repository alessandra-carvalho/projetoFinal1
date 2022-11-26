package com.mobile.projetofinal1.presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.projetofinal1.R;
import com.mobile.projetofinal1.database.DBUser;
import com.mobile.projetofinal1.model.User;

import java.util.ArrayList;
import java.util.List;


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

        DBUser objDBUser = new DBUser();
        List<User> listUser = new ArrayList<>(objDBUser.buscarDadosLogin(edit_email.getText().toString(), edit_senha.getText().toString(), this));
        int n = listUser.size();

        //verifica se usuario existe no BD
        if(n > 0){

            //percorre a lista comparando se os dados estão corretos
            for (int i=0; i<n; i++){

                //verifica se os dados de e-mail e senha estão corretos
                if (edit_email.getText().toString().equals(listUser.get(i).getEmail().toString())){
                    mensagem("Usuário já cadastrado!");
                }
            }

        }else{

            // popular a classe user construtor com os objetos da tela de cadastro
            User objUser = new User(st_nome, st_email, st_senha);

            // chamar a classe DBUser metodo inserir registros passando parametro User e main
            DBUser.inserirRegistro(objUser, this);

            //após fechar e limpar os campos da tela
            edit_nome.setText(null);
            edit_email.setText(null);
            edit_senha.setText(null);

            //após as verificações vai para uma nova activity
            Intent intent = new Intent(getApplicationContext(), telaLogin.class);
            startActivity(intent);
        }



    }

    //método para passar a msg
    private void mensagem(String msg){
        Toast.makeText(telaCadastro.this, msg, Toast.LENGTH_SHORT).show();
        edit_email.requestFocus();
    }

}