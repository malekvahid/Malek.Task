package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.malektask.ImdbDetails.MoviesTitle;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class AsyncHttpTitleActivity extends AppCompatActivity {
    private static final String TAG = "AsyncHttpTitleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http_title);



        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        final String titleaddress = "https://www.omdbapi.com/?t="+title+"&apikey=70ad462a";
        final AsyncHttpClient client1 = new AsyncHttpClient();


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
