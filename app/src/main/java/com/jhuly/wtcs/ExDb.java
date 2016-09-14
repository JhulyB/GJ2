package com.jhuly.wtcs;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by sti01 on 23/08/16.
 */
public class ExDb extends AsyncTask<String,Void,ResultSet> {

    private Connection connection;
    private String query;

    public ExDb(Connection connection, String query) {
        this.connection = connection;
        this.query = query;
    }

    @Override
    protected ResultSet doInBackground(String... strings) {
        ResultSet resultSet = null;

        try {
            resultSet = connection.prepareStatement(query).executeQuery();
        }catch (Exception ex){

        }finally {
            try {
                connection.close();
            }catch (Exception ex){

            }
        }

        return  resultSet;
    }
}
