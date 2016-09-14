package com.jhuly.wtcs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by STI01 on 11/09/2016.
 */
public class ActivityRegisterUser extends AppCompatActivity {

    private User user;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextConfirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        this.user = new User();
        this.editTextEmail = (EditText) findViewById(R.id.ET_registerUser_email);
        this.editTextPassword = (EditText) findViewById(R.id.ET_registerUser_password);
        this.editTextConfirmPassword = (EditText) findViewById(R.id.ET_registerUser_confirmPassword);

        Intent intent = getIntent();

        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){
                this.user.setIdUser(bundle.getInt("idUser"));
                this.editTextEmail.setText(bundle.getString("email"));
                this.editTextPassword.setText(bundle.getString("password"));
            }
        }
    }

    public void cadastro(View view){

       // if(this.editTextPassword != this.editTextConfirmPassword){
       //     Toast.makeText(this,"As senhas não correspondem",Toast.LENGTH_LONG).show();
       //     this.editTextPassword.setText("");
       //     this.editTextConfirmPassword.setText("");
       // }else{
            Log.d("TESTE DE CONEXAO","INICIO DO CADASTRO");
            this.user.setEmail(this.editTextEmail.getText().toString());
            this.user.setPassword(this.editTextPassword.getText().toString());
            this.user.registerUser();
            Toast.makeText(this,this.user.get_mensagem(),Toast.LENGTH_LONG).show();
            if (user.is_status()){
                finish();
            }
            Log.d("TESTE DE CONEXAO","FIM DO CADASTRO");
        }

    }


