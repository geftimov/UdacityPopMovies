package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.List;

public interface PostersView {

    void onMoviesSuccess(final List<Movie> movies);

    void onMoviesError(final String message);
}
