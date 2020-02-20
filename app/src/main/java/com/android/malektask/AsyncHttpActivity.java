package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        //adapter
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        final String address = "https://www.omdbapi.com/?s="+title+"&apikey=70ad462a";
        final AsyncHttpClient client = new AsyncHttpClient();

        //get Search Title
        client.get(address,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Gson gson = new Gson();
                Movies movies = gson.fromJson(response.toString(),Movies.class);

                // Show Search Title to Recycler View
                    RecyclerView Recycler = findViewById(R.id.Recycler);
                    TestAdapter adapter = new TestAdapter(movies.getSearch());
                    Recycler.setAdapter(adapter);
                    Recycler.setLayoutManager(new LinearLayoutManager(AsyncHttpActivity.this
                    , RecyclerView.VERTICAL, false));

                /*

                \\ Log D TAG
                Log.d(TAG, "test 1: " + response.toString( ) );
                Log.d(TAG, "test 2: " + movies.getTotalResults());
                Log.d(TAG, "test 3:getTitle " + movies.getSearch().get(0).getTitle());
                Log.d(TAG, "test 4:getType " + movies.getSearch().get(0).getType());
                Log.d(TAG, "test 5:getYear " + movies.getSearch().get(0).getYear());
                Log.d(TAG, "test 6:getImdbID " + movies.getSearch().get(0).getImdbID());
                Log.d(TAG, "test 7:getPoster" + movies.getSearch().get(0).getPoster());
                */
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });


    }


}
