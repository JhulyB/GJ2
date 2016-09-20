package com.jhuly.wtcs.ACTIVITY;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.jhuly.wtcs.R;

/**
 * Created by Jhuly on 29/08/2016.
 */
public class ActivityRegisterProfi extends AppCompatActivity {

    private static final String[] especialidades = {"Construção", "Costura", "Informatica"};
    ArrayAdapter<String> Especialidades;

    private Spinner spinnerEspecialidade;

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextPhone;
    private EditText editTextCity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profi);

        editTextFirstName = (EditText)findViewById(R.id.ET_registerProfi_firstName);
        editTextLastName = (EditText)findViewById(R.id.ET_registerProfi_lastName);
        editTextPhone = (EditText)findViewById(R.id.ET_registerProfi_phone);
        editTextCity = (EditText)findViewById(R.id.ET_registerProfi_city);

        //TRATANDO SPINNER
        //modelo do spinner
        Especialidades = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, especialidades);
        //capturando o spinner do xml pela id
        spinnerEspecialidade = (Spinner)findViewById(R.id.spinner_registerProfi);
        spinnerEspecialidade.setAdapter(Especialidades);

    }
}
