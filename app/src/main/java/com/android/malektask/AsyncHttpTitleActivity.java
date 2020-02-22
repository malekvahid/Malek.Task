package com.android.malektask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.malektask.ImdbDetails.MoviesTitle;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;



public class AsyncHttpTitleActivity extends AppCompatActivity {
    private static final String TAG = "AsyncHttpTitleActivity";





    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
            // Details On Selected Film Title On RecyclerView
            setContentView(R.layout.activity_async_http_title);
            Intent intent = getIntent();
            String imdbId = intent.getStringExtra("id");
            String address = "https://www.omdbapi.com/?i="+imdbId+"&apikey=70ad462a";

            final TextView txtdetails = findViewById(R.id.txtDetails);
            final ImageView imageView = findViewById(R.id.imgTitle);
            final RatingBar ratingBar = findViewById(R.id.ratingbar);
            final float[] Rat = new float[1];

            AsyncHttpClient client = new AsyncHttpClient();
            client.get(address, new  JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

                    super.onSuccess(statusCode, headers, response);

                    Gson gson = new Gson();
                    MoviesTitle moviesTitle = gson.fromJson(response.toString(), MoviesTitle.class);

                    // Log d Details On Selected Film Title On RecyclerView


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

                    //txtCountry.setText("Country: " + prop.getCountry());

                    Rat[0] = Float.parseFloat(moviesTitle.getImdbRating());

                ratingBar.setRating(Rat[0]/2);

                   // ratingBar.setRating((float) (moviesTitle.getRated()));
                  //  ratingBar.setRating(moviesTitle.getRated());
                  //  ratingBar.setRating(moviesTitle.getRatings());
                    //ratingBar.setRating((moviesTitle.getImdbRating()));


                    txtdetails.setText(
                        "Title :"+ moviesTitle.getTitle()+ '\n'+
                       '\n' + "Year: " + moviesTitle.getYear() + '\n'+
                       '\n'+ "Rated: " + moviesTitle.getRated() + '\n'+
                       '\n'+ "Released : " + moviesTitle.getReleased() + '\n'+
                       '\n'+ "Runtime: " + moviesTitle.getRuntime() + '\n'+
                       '\n'+ "Genre: " + moviesTitle.getGenre() + '\n'+
                       '\n'+ "Director : " + moviesTitle.getDirector() + '\n'+
                       '\n'+ "Writer : " + moviesTitle.getWriter() + '\n'+
                       '\n'+ "Actors : " + moviesTitle.getActors() + '\n'+
                       '\n'+ "Plot: " + moviesTitle.getPlot() + '\n'+
                       '\n'+ "Language : " + moviesTitle.getLanguage() + '\n'+
                       '\n'+ "Country : " + moviesTitle.getCountry() + '\n'+
                       '\n'+ "Awards: " + moviesTitle.getAwards() + '\n'+
                       '\n'+ "Metascore : " + moviesTitle.getMetascore() + '\n'+
                       '\n'+ "imdbRating : " + moviesTitle.getImdbRating() + '\n'+
                       '\n'+ "imdbVotes : " + moviesTitle.getImdbVotes() + '\n'+
                       '\n'+ "Type : " + moviesTitle.getType() + '\n'+
                       '\n'+ "DVD : " + moviesTitle.getDVD() + '\n'+
                       '\n'+ "BoxOffice : " + moviesTitle.getBoxOffice() + '\n'+
                       '\n'+ "Production : " + moviesTitle.getProduction()+'\n');

                        String imgUrl = moviesTitle.getPoster();
                        Picasso.get().load(imgUrl).into(imageView);






            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });




    }
}
