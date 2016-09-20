package com.jhuly.wtcs.ACTIVITY;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jhuly.wtcs.R;

/**
 * Created by Jhuly on 24/08/2016.
 */
public class Teste_FragmentRatingBar extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rating_bar, container, false);
    }

    private RatingBar ratingbar;
    private TextView txtValorAvaliacao;
    private Button btnSubmit;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        addListenerOnRatingBar();
        addListenerOnButton();
    }

    private void addListenerOnButton() {
        ratingbar = (RatingBar)getActivity().findViewById(R.id.ratingbar);
        btnSubmit = (Button)getActivity().findViewById(R.id.btnSubmit);

        //se o botao for clicado, exiba o valor de avaliacao corrente
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), String.valueOf(ratingbar.getRating()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addListenerOnRatingBar() {
        ratingbar = (RatingBar) getActivity().findViewById(R.id.ratingbar);
        txtValorAvaliacao = (TextView)getActivity().findViewById(R.id.txtValorAvaliacao);

        //se o valor mudar, exiba o valor de avaliacao atual no resultado (textview) automaticamente
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtValorAvaliacao.setText(String.valueOf(rating));
            }
        });
    }


}
