package com.eftimoff.udacitypopmovies.favourites;

import com.eftimoff.udacitypopmovies.app.models.Movie;

import java.util.List;

public interface FavouritesView {

    void onMoviesSuccess(final List<Movie> movies);

    void onMoviesError(final String message);

}
