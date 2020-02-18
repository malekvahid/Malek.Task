package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;

import com.android.malektask.Imdb.Movies;
import com.android.malektask.Imdb.Search;
import com.android.malektask.Pray.PrayTime;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;



public class AsyncHttpActivity extends AppCompatActivity {


    private static final String TAG = "AsyncHttpActivity";

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http);
        final String address = "https://www.omdbapi.com/?s=gladiator&apikey=70ad462a";
    //  final String address = "http://api.aladhan.com/v1/timingsByCity?city=Dubai&country=United%20Arab%20Emirates&method=8";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(address,new JsonHttpResponseHandler(){






            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                /*
                try {
                    System.out.println(response.toString());
                    JSONObject object = new JSONObject(response.toString());
                    String data = object.getString("data");
                    JSONObject object1 = new JSONObject(data);
                    String data1 = object1.getString("timings");
                    JSONObject object2 = new JSONObject(data1);
                    String asr = object2.getString("Asr");
                    Log.d(TAG, "run: " + asr);
                }
                        catch (Exception e){
                    e.printStackTrace();
                    }
                */

            /*
                Gson gson = new Gson();
                PrayTime time = gson.fromJson(response.toString(),PrayTime.class);
                Log.d(TAG, "onSuccess: "+ time.getData().getTimings().getAsr());
             */



            /*
                JSONArray jsonarray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    String name = jsonobject.getString("name");
                }

                */

                super.onSuccess(statusCode, headers, response);
                try {
                    JSONObject object = new JSONObject(response.toString());
                    JSONArray array = new JSONArray(object.getString("Search"));




                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }





       
                Gson gson = new Gson();
                Movies movies = gson.fromJson(response.toString(),Movies.class);
                Log.d(TAG, "test 1: " + response.toString( ) );
                Log.d(TAG, "test 2: " + movies.getTotalResults());
                Log.d(TAG, "test 3:Title( " + movies.getSearch().get(2).getTitle());
                Log.d(TAG, "test 4:Class( " + movies.getSearch().get(2).getClass());
                Log.d(TAG, "test 5:Year() " + movies.getSearch().get(2).getYear());
                Log.d(TAG, "test 6:ImdbID " + movies.getSearch().get(2).getImdbID());
                Log.d(TAG, "test 7:Type() " + movies.getSearch().get(2).getType());
                Log.d(TAG, "test 8:Year() " + movies.getSearch().get(2).getYear());
              //  Log.d(TAG, "run: " +  );

            }











            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });




    }
}
