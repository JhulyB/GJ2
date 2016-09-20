package com.jhuly.wtcs.DAO;

import android.util.Log;
import com.jhuly.wtcs.UTILITARIOS.Banco;
import com.jhuly.wtcs.MODELO.User;
import com.jhuly.wtcs.UTILITARIOS._Default;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by STI01 on 11/09/2016.
 */
public class UserDAO extends _Default {

    Banco banco = new Banco();


    public void registerUser(User user) {
        String comando = "";

        Log.d("TESTE DE CONEXAO", "RESISTER USER");
        if (user.getIdUser() == -1) {
            try {
                comando = String.format("INSERT INTO usuario (email,senha) VALUES ('%s', '%s');",
                        user.getEmail(), user.getPassword());
                Log.d("TESTE DE CONEXAO", "TRY INSERT");
                this._mensagem = "Cadastrado com sucesso !!";
            } catch (Exception e) {
                this._mensagem = e.getMessage();
            }
        }


        this.banco.execute(comando);
        this._mensagem = banco.get_mensagem();
        this._status = banco.is_status();
    }


    public boolean checarLogin(String email,String senha) throws SQLException {

        ResultSet resultSet;
        boolean resposta = false;
        String comando ="";
        try {
            Log.d("USERDAO","COMANDO SQL");
            comando = String.format("SELECT * FROM usuario where email = '%s' and senha = '%s'",
                    email,senha);
            resultSet = this.banco.select(comando);
            Log.d("USERDAO","ANTES DO RESULTSET");
            if (resultSet != null) {
                Log.d("USERDAO","ANTES DO WHILE DEPOIS DO RESULTSET");
                while (resultSet.next()) {
                    Log.d("USERDAO","DENTRO DO WHILE");
                    User user = new User();
                    user.setIdUser(resultSet.getInt("id_usuario"));
                    user.setEmail(resultSet.getString("email"));
                    user.setPassword(resultSet.getString("senha"));

                    if(user.getEmail().equals(email) && user.getPassword().equals(senha)){
                        Log.d("USERDAO","DENTRO DA CONDIÇÃO");
                        resposta = true;
                        this._mensagem = "Logando......";
                    }
                    Log.d("USERDAO","DEPOIS DO IF");
                }
            }else{
                this._mensagem = "ERRO!!!";
            }
        }catch (Exception e) {
            this._mensagem = e.getMessage();
            this._status = false;
        }
            return  resposta;
    }


}
