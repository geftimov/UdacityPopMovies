package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import android.view.View;

import com.eftimoff.udacitypopmovies.models.Movie;

public interface PostersFragmentActions {

    void onMovieClicked(final View view, final Movie movie);
}
