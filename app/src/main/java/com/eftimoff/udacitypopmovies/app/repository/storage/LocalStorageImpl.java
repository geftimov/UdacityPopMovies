package com.eftimoff.udacitypopmovies.app.repository.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.data.MoviesContract;

import java.util.ArrayList;
import java.util.List;

public class LocalStorageImpl implements LocalStorage {

    private final Context context;

    public LocalStorageImpl(Context context) {
        this.context = context;
    }

    @Override
    public boolean isFavourite(int movieId) {
        boolean favorite = false;
        Cursor cursor = context.getContentResolver().query(
                MoviesContract.FavouriteEntry.CONTENT_URI,
                null,
                MoviesContract.COLUMN_MOVIE_ID_KEY + " = " + movieId,
                null,
                null
        );
        if (cursor != null) {
            favorite = cursor.getCount() != 0;
            cursor.close();
        }
        return favorite;
    }

    @Override
    @NonNull
    public List<Movie> getFavourites() {
        List<Movie> movies = new ArrayList<>();
        Cursor cursor = context.getContentResolver().query(
                MoviesContract.FavouriteEntry.CONTENT_URI,
                null,
                null,
                null,
                null
        );

        if (cursor == null) {
            return movies;
        }

        try {
            while (cursor.moveToNext()) {
                movies.add(new Movie(cursor));
            }
        } finally {
            cursor.close();
        }

        return movies;
    }

    @Override
    public void saveFavourite(Movie movie) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MoviesContract.FavouriteEntry._ID, movie.getId());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_TITLE, movie.getTitle());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_DESCRIPTION, movie.getDescription());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_RELEASE_DATE, movie.getReleaseDate());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_IMAGE_URL, movie.getImageUrl());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_SCORE, movie.getScore());
        contentValues.put(MoviesContract.FavouriteEntry.COLUMN_GENRES, movie.getGenres());

        context.getContentResolver().insert(MoviesContract.FavouriteEntry.CONTENT_URI, contentValues);
    }

    @Override
    public void removeFavourite(int movieId) {
        context.getContentResolver().delete(
                MoviesContract.FavouriteEntry.CONTENT_URI,
                MoviesContract.COLUMN_MOVIE_ID_KEY + " = " + movieId,
                null
        );
    }


}
