package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;

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
        RecyclerView recycler = findViewById(R.id.recycler);


        //adapter



        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        final String address = "https://www.omdbapi.com/?s="+title+"&apikey=70ad462a";

        final String titleaddress = "https://www.omdbapi.com/?t="+title+"&apikey=70ad462a";
        final AsyncHttpClient client = new AsyncHttpClient();
        final AsyncHttpClient client1 = new AsyncHttpClient();

        //get Search film
        client.get(address,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Gson gson = new Gson();
                Movies movies = gson.fromJson(response.toString(),Movies.class);

                Log.d(TAG, "test 1: " + response.toString( ) );
                Log.d(TAG, "test 2: " + movies.getTotalResults());
                Log.d(TAG, "test 3:getTitle " + movies.getSearch().get(0).getTitle());
                Log.d(TAG, "test 4:getType " + movies.getSearch().get(0).getType());
                Log.d(TAG, "test 5:getYear " + movies.getSearch().get(0).getYear());
                Log.d(TAG, "test 6:getImdbID " + movies.getSearch().get(0).getImdbID());
                Log.d(TAG, "test 7:getPoster" + movies.getSearch().get(0).getPoster());

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

        // get Title
        client1.get(titleaddress,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                Gson gson = new Gson();
                MoviesTitle moviesTitle = gson.fromJson(response.toString(), MoviesTitle.class);

                Log.d(TAG, "test 8: " + response.toString( ) );
                Log.d(TAG, "test 9: " + moviesTitle.getTitle());
                Log.d(TAG, "test 10:getTitle " + moviesTitle.getActors());
                Log.d(TAG, "test 11:getType " + moviesTitle.getActors());
                Log.d(TAG, "test 12:getYear " + moviesTitle.getAwards());
                Log.d(TAG, "test 13:getImdbID " + moviesTitle.getBoxOffice());
                Log.d(TAG, "test 14:getPoster" + moviesTitle.getCountry());

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }







}
