package com.project.andjokeslib;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;


/**
 * Created on july 2018
 */
public class ActJokesFrag extends Fragment {
    
    public static final String JOKE_KEY = "gce_result";

    public ActJokesFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vwView = inflater.inflate(R.layout.lotjokesfrag, container, false);
        String strGceOut = getActivity().getIntent().getStringExtra(JOKE_KEY);
        TextView txtGceOut = (TextView) vwView.findViewById(R.id.tvJokes);
        txtGceOut.setText(strGceOut);

        return vwView;
    }

}
