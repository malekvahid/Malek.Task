package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.malektask.Imdb.Movies;
import com.android.malektask.ImdbDetails.MoviesTitle;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class AsyncHttpActivity extends AppCompatActivity {
    private static final String TAG = "AsyncHttpActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http);
        final String address = "https://www.omdbapi.com/?s=gladiator&apikey=70ad462a";
        final String titleaddres = "https://www.omdbapi.com/?t=gladiator&apikey=70ad462a";
        final AsyncHttpClient client = new AsyncHttpClient();
        final AsyncHttpClient client1 = new AsyncHttpClient();

        //get Search film
        client.get(address,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Gson gson = new Gson();
                Movies movies = gson.fromJson(response.toString(),Movies.class);
             /*
                Log.d(TAG, "test 1: " + response.toString( ) );
                Log.d(TAG, "test 2: " + movies.getTotalResults());
                Log.d(TAG, "test 3:getTitle " + movies.getSearch().get(2).getTitle());
                Log.d(TAG, "test 4:getType " + movies.getSearch().get(2).getType());
                Log.d(TAG, "test 5:getYear " + movies.getSearch().get(2).getYear());
                Log.d(TAG, "test 6:getImdbID " + movies.getSearch().get(2).getImdbID());
                Log.d(TAG, "test 7:getPoster" + movies.getSearch().get(2).getPoster());
              */
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        // get Title
        client1.get(titleaddres,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Gson gson = new Gson();
                MoviesTitle moviesTitle = gson.fromJson(response.toString(), MoviesTitle.class);
            /*
                Log.d(TAG, "test 1: " + response.toString( ) );
                Log.d(TAG, "test 2: " + moviesTitle.getTitle());
                Log.d(TAG, "test 3:getTitle " + moviesTitle.getActors());
                Log.d(TAG, "test 4:getType " + moviesTitle.getActors());
                Log.d(TAG, "test 5:getYear " + moviesTitle.getAwards());
                Log.d(TAG, "test 6:getImdbID " + moviesTitle.getBoxOffice());
                Log.d(TAG, "test 7:getPoster" + moviesTitle.getCountry());
            */
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
