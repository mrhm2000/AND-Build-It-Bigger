package com.udacity.gradle.builditbigger.backend;
import com.project.javajokeslib.JokesBook;

/**
 * Created on july 2018
 */

public class BackendBean {

    private String strData;

    public String getData() {

        strData = new JokesBook().getJoke();
        return strData;

    }
}