package com.jhuly.wtcs.ACTIVITY;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jhuly.wtcs.DAO.UserDAO;
import com.jhuly.wtcs.MODELO.User;
import com.jhuly.wtcs.R;

import java.sql.SQLException;

/**
 * Created by Jhuly on 11/09/2016.
 */
public class activity_login extends AppCompatActivity {


     EditText editTextEmail;
     EditText editTextPassword;
     TextView textViewCadastrar;
     User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.editTextEmail = (EditText)findViewById(R.id.ET_Sign_Email);
        this.editTextPassword = (EditText)findViewById(R.id.ET_Sign_User);
        this.textViewCadastrar = (TextView)findViewById(R.id.TV_LoginCadastrar);
        textViewCadastrar.setOnClickListener(TVCadastrar);

        Button BT_Login = (Button)findViewById(R.id.BT_Sign_Login);
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

    public void LoginEfetuado() {
        UserDAO userDAO = new UserDAO();


        try {
            if (userDAO.checarLogin(editTextEmail.getText().toString(),editTextPassword.getText().toString()) == true) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this,userDAO.get_mensagem(),Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Usuario o senha Inválida",Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void CadatrarUser(){
        Intent intent = new Intent(this, ActivityRegisterUser.class);
        startActivity(intent);
    }

}
