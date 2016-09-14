package com.jhuly.wtcs;

import android.util.Log;
import android.widget.Toast;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by STI01 on 11/09/2016.
 */
public class User extends _Default {

    private int idUser;
    private String email;
    private String password;

    public User() {
        super();
        this.idUser = -1;
        this.email = "";
        this.password = "";
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void registerUser(){
        String comando = "";

        Log.d("TESTE DE CONEXAO","RESISTER USER");
        if(this.getIdUser() == -1){
            try {
                comando = String.format("INSERT INTO usuario (email,senha) VALUES ('%s', md5('%s'));",
                        this.getEmail(),this.getPassword());
                Log.d("TESTE DE CONEXAO","TRY INSERT");
                this._mensagem = "Cadastrado com sucesso !!";
            }catch (Exception e){
                this._mensagem = e.getMessage();
            }
        }

        Banco banco = new Banco();
        banco.execute(comando);
        this._mensagem = banco.get_mensagem();
        this._status = banco.is_status();
    }

    public boolean checarLogin(String email,String senha)  {
        boolean resposta = false;
        String comando ="";
        Banco banco = new Banco();
        ResultSet rg ;



        try {

            comando = String.format("SELECT * FROM usuario where email = ? and senha = md5(?);");
            rg = banco.select(comando);

            if (rg != null){
                while (rg.next()){
                    User user = new User();
                    user.setIdUser(rg.getInt("idUser"));
                    user.setEmail(rg.getString("email"));
                    user.setPassword(rg.getString("password"));
                    resposta = true;
                }
            }

        }catch (Exception e){
          //  this._mensagem = "Email ou senha inválido !!! ";
        }

        return resposta;
    }
}