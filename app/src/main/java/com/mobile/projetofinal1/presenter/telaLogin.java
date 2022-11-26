package com.mobile.projetofinal1.presenter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

public class telaLogin extends AppCompatActivity {

    private TextView text_cadastro;
    //criando as variaveis
    EditText edit_email;
    EditText edit_senha;
    Button bt_acessar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //faz a ligação com o id de cada objeto da activity
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        bt_acessar = findViewById(R.id.bt_acessar);

        //faz com que o foco seja o e-mail na tela principal
        edit_email.requestFocus();

        //esconde a barra azul da tela
        getSupportActionBar().hide();

        //redireciona p/ a tela de cadastro
        IniciarTelaCadastro();

        // popula lista de usuarios
//        User user1 = new User(20, "ale1", "ale1@dominio.com", "1234");
//        User user2 = new User(25, "ana2", "ana2@dominio.com", "5678");

        //add os usuários na lista
//        List<User> listUser = new ArrayList<>();
//        listUser.add(user1);
//        listUser.add(user2);

        //busca usuário conforme campos preenchidos







        //validação do evento do botão login
        bt_acessar.setOnClickListener(new View.OnClickListener() {
            private View view;

            @Override
            public void onClick(View view) {
                this.view = view;

                DBUser objDBUser = new DBUser();
                //objDBUser.buscarDadosLogin(edit_email.getText().toString(), edit_senha.getText().toString(), this);

                List<User> listUser = new ArrayList<>(objDBUser.buscarDadosLogin(edit_email.getText().toString(), edit_senha.getText().toString(), telaLogin.this));

                //valida se o login e senha estão na lista de usuários cadastrados
                int n = listUser.size();
                boolean boolUserValido = false;

                //verifica se usuario não existe no BD
                if(n == 0){
                    mensagem("Usuário ou senha inválido!");
                }

                //percorre a lista comparando se os dados estão corretos
                for (int i=0; i<n; i++){

                    //verifica se os dados de e-mail e senha estão corretos
                    if (edit_email.getText().toString().equals(listUser.get(i).getEmail().toString())
                            &&  edit_senha.getText().toString().equals(listUser.get(i).getSenha().toString())){
                        boolUserValido = true;
                    }
                }
                //verifica se os campos estão em branco mostra a msg
                if(edit_email.getText().toString().isEmpty() || edit_senha.getText().toString().isEmpty()){
                    //se as opções acima ocorrerem, mostrará a msg abaixo e .show serve para mostrar na tela
                    mensagem("Insira seus dados!");

                } // teste para ver se os dados estão corretos
                else if(boolUserValido){

                    //após as verificações vai para uma nova activity
                    Intent intent = new Intent(getApplicationContext(), telaUsuario.class);
                    startActivity(intent);

                }
//                else{
//                    mensagem("Dados incorretos!");
//                }
            }
        });

        //chamar a tela de cadastro
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
    private void IniciarTelaCadastro(){
        text_cadastro = findViewById(R.id.text_cadastro);
    }

    //método para passar a msg
    private void mensagem(String msg){
        Toast.makeText(telaLogin.this, msg, Toast.LENGTH_SHORT).show();
        edit_email.requestFocus();
    }
}