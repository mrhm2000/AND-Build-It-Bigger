package com.udacity.gradle.builditbigger;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created on july 2018
 */

public class ActMainFrag extends Fragment {

    public ActMainFrag() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.lotfragmain, container, false);


        return root;
    }
}
