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
            // Details On Selected Film Title On RecyclerView
            setContentView(R.layout.activity_movei);
            Intent intent = getIntent();
            String imdbId = intent.getStringExtra("id");
            String address = "https://www.omdbapi.com/?i="+imdbId+"&apikey=70ad462a";

            AsyncHttpClient client = new AsyncHttpClient();
            client.get(address, new  JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                    super.onSuccess(statusCode, headers, response);

                    Gson gson = new Gson();
                    MoviesTitle moviesTitle = gson.fromJson(response.toString(), MoviesTitle.class);

                    // Log d Details On Selected Film Title On RecyclerView

                    Log.d(TAG, "test 1 :getActors " + moviesTitle.getActors());
                    Log.d(TAG,"test 01 Title: " + moviesTitle.getTitle());
                    Log.d(TAG,"test 02 Year: " + moviesTitle.getYear());
                    Log.d(TAG,"test 03 Rated: " + moviesTitle.getRated());
                    Log.d(TAG,"test 04 Released: " + moviesTitle.getReleased());
                    Log.d(TAG,"test 05 Runtime: " + moviesTitle.getRuntime());
                    Log.d(TAG,"test 06 Genre: " + moviesTitle.getGenre());
                    Log.d(TAG,"test 07 Director: " + moviesTitle.getDirector());
                    Log.d(TAG,"test 08 Writer: " + moviesTitle.getWriter());
                    Log.d(TAG,"test 09 Actors: " + moviesTitle.getActors());
                    Log.d(TAG,"test 10 Plot: " + moviesTitle.getPlot());
                    Log.d(TAG,"test 11 Language: " + moviesTitle.getLanguage());
                    Log.d(TAG,"test 12 Country: " + moviesTitle.getCountry());
                    Log.d(TAG,"test 13 Awards: " + moviesTitle.getAwards());
                    Log.d(TAG,"test 14 Poster: " + moviesTitle.getPoster());
                    Log.d(TAG,"test 15 Ratings: " + moviesTitle.getRatings());
                    Log.d(TAG,"test 16 Metascore: " + moviesTitle.getMetascore());
                    Log.d(TAG,"test 17 imdbRating: " + moviesTitle.getImdbRating());
                    Log.d(TAG,"test 18 imdbVotes: " + moviesTitle.getImdbVotes());
                    Log.d(TAG,"test 19 imdbID: " + moviesTitle.getImdbID());
                    Log.d(TAG,"test 20 Type: " + moviesTitle.getType());
                    Log.d(TAG,"test 21 DVD: " + moviesTitle.getDVD());
                    Log.d(TAG,"test 22 BoxOffice: " + moviesTitle.getBoxOffice());
                    Log.d(TAG,"test 23 Production: " + moviesTitle.getProduction());
                }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });




    }
}
