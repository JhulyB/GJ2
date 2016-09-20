package com.jhuly.wtcs.MODELO;

import com.jhuly.wtcs.UTILITARIOS.Banco;
import com.jhuly.wtcs.UTILITARIOS._Default;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by STI01 on 11/09/2016.
 */
public class User {

    private int idUser;
    private String email;
    private String password;
    private PreparedStatement pst;


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




}
