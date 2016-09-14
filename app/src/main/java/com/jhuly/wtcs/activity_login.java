package com.jhuly.wtcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Jhuly on 11/09/2016.
 */
public class activity_login extends AppCompatActivity {


    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewCadastrar;
    private User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.editTextEmail = (EditText)findViewById(R.id.ET_Sign_Email);
        this.editTextPassword = (EditText)findViewById(R.id.ET_Sign_Password);
        this.textViewCadastrar = (TextView)findViewById(R.id.TV_LoginCadastrar);
        textViewCadastrar.setOnClickListener(TVCadastrar);

        Button BT_Login = (Button)findViewById(R.id.BT_Login);
        BT_Login.setOnClickListener(EfetuarLogin);

    }

    private View.OnClickListener TVCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CadatrarUser();
        }
    };

    private View.OnClickListener EfetuarLogin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            LoginEfetuado();

        }
    };

    public void LoginEfetuado(){

        try {
            if(user.checarLogin(editTextEmail.toString(),editTextPassword.toString()) == true){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }catch (Exception e){
            user._mensagem = e.getMessage();
        }


    }

    public void CadatrarUser(){
        Intent intent = new Intent(this, ActivityRegisterUser.class);
        startActivity(intent);
    }

}
