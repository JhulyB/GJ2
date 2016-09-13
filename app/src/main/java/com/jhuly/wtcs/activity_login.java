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

    private Login login;
    private EditText editTextUser;
    private EditText editTextPassword;
    private TextView textViewCadastrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.login = new Login();
        this.editTextUser = (EditText)findViewById(R.id.ETLogin_User);
        this.editTextPassword = (EditText)findViewById(R.id.ETLogin_Pass);

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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void CadatrarUser(){
        Intent intent = new Intent(this, ActivityRegisterUser.class);
        startActivity(intent);
    }

}
