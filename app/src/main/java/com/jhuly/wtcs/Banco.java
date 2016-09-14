package com.jhuly.wtcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by sti01 on 23/08/16.
 */
public class Banco extends _Default implements Runnable {

    private Connection conn;
    private String host = "192.168.19.2";// utilizar o IP da maquina !!!!
    private String db = "android";
    private int porta = 5433;
    private String user = "postgres";
    private String password = "postegre97";
    private String url = "jdbc:postgresql://%s:%d/%s";



    public Banco(){
        super();
        this.url = String.format(this.url,this.host, this.porta, this.db);

        this.conecta();
        this.desconecta();

    }

    @Override
    public void run() {
        try{
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(this.url,this.user,this.password);
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
    }

    public void conecta(){
        Thread thread = new Thread(this);
        thread.start();
        try{
            thread.join();
        }catch (Exception ex){
            this._mensagem = ex.getMessage();
            this._status = false;
        }
    }

    private void desconecta(){

        if(this.conn != null){
            try {
                this.conn.close();
            }catch (Exception ex){
                this._mensagem = ex.getMessage();
                this._status = false;
            }finally {
                this.conn = null;
            }
        }
    }

    public ResultSet select(String query){
        this.conecta();
        ResultSet resultSet = null;

        try {
            resultSet = new ExDb(this.conn,query).execute().get();
        }catch (Exception ex){
            this._status = false;
            this._mensagem = ex.getMessage();
        }
        return resultSet;
    }

    public ResultSet execute(String query){
        this.conecta();
        ResultSet resultSet = null;

        try {
            resultSet = new ExDb(this.conn,query).execute().get();
        }catch (Exception ex){
            this._status = false;
            this._mensagem = ex.getMessage();
        }
        return resultSet;
    }
}
