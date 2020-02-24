package com.android.malektask;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.android.malektask.Imdb.Search;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {

        String TABLE_NAME = "OfflineMovies";
    private Object List;


    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_QUERY = " CREATE TABLE " + TABLE_NAME + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "year INTEGER," +
                "imdbID TEXT," +
                "type TEXT," +
                "poster TEXT" +
                ")";
            db.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    public void insertOfflineMovies(String title,Integer year,String imdbID,String type,String poster ){
        String INSERT_TABLE_QUERY = "INSERT INTO " +TABLE_NAME + "title,year,imdbID,type, poster) VALUES("
                +"'" +title +"'"+ ","
               +year + ","
               +"'" +imdbID + "'"+","
               +"'" +type + "'"+","
               +"'" +poster+"'"
                + ")";

                SQLiteDatabase db = this.getWritableDatabase();
                db.execSQL(INSERT_TABLE_QUERY);
                db.close();
    }

    public java.util.List<Search> getALLTitlesName(){

        String GET_ALL_Titles_Name = "SELECT title FROM "+TABLE_NAME;
        //List<String> ;
        List<Search> searchTitle = new ArrayList<>();

        Search mSearch;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(GET_ALL_Titles_Name,null);

        while (c.moveToNext()){
            List = List + c.getString(0);

        // "title,year,imdbID,type, poster)

            mSearch = new Search();
            mSearch.setTitle(c.getString(0));
            mSearch.setYear(c.getString(1));
            mSearch.setImdbID(c.getString(2));
            mSearch.setType(c.getString(3));
            mSearch.setPoster(c.getString(4));
            searchTitle.add(mSearch);


        }

        db.close();

        return searchTitle;


    }

}
