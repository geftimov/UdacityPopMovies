package com.eftimoff.udacitypopmovies.popmovies.posters;

import com.eftimoff.udacitypopmovies.app.models.Movie;

import java.util.List;

public interface PostersView {

    void onMoviesSuccess(final List<Movie> movies);

    void onMoviesError(final String message);
}
