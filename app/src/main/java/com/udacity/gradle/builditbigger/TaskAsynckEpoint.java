package com.udacity.gradle.builditbigger;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import android.os.AsyncTask;
import com.google.api.client.extensions.android.http.AndroidHttp;
import android.content.Context;
import android.content.Intent;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.project.andjokeslib.ActJokes;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import java.io.IOException;


/**
 * Created on july 2018
 */

class TaskAsynckEpoint extends AsyncTask<Context, Void, String> {
    public static MyApi ApiService = null;
    public static final String JOKE_KEY = "gce_result";
    private Context ctContext;
    public static final String strEMPTY_STRING = "";
    private boolean blException = false;

    private GetJoke  JokeListener = null;

    @Override
    protected String doInBackground(Context...params) {
        if(ApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            ApiService = builder.build();
        }

        ctContext = params[0];

        try {
            return ApiService.getRandomJokeService().execute().getData();
        } catch (IOException e) {
            blException=true;
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        //result=strEMPTY_STRING; // Android Endpoint test with an empty string
        if (this.JokeListener != null && blException==false)
            this.JokeListener.onComplete(result);

        final Intent intent = new Intent(ctContext, ActJokes.class);
        intent.putExtra(JOKE_KEY, result);
        ctContext.startActivity(intent);


    }


    public interface GetJoke {
        public void onComplete(String result);
    }

    public void setListener(GetJoke  listener) {
        this.JokeListener = listener;
    }
}

