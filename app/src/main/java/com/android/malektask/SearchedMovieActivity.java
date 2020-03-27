package com.android.malektask;




import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.malektask.imdbProp.MovieProperties;

import java.util.ArrayList;
import java.util.List;





public class SearchedMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_movie);
        RecyclerView recycler = findViewById(R.id.searchedRecycler);
       // final Database db =new Database(SearchedMovieActivity.this, "Imdb", null, 1);

       final DataBase db = new DataBase(SearchedMovieActivity.this, "Imdb", null, 1);
        List<MovieProperties> searchedList = new ArrayList<>();
        searchedList = db.getMoviesDB();
        SearchedAdapter adapter = new SearchedAdapter(searchedList);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(SearchedMovieActivity.this
                , RecyclerView.VERTICAL, false));
    }
}
