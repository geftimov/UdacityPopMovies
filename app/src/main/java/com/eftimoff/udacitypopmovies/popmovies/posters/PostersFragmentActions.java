package com.eftimoff.udacitypopmovies.popmovies.posters;

import android.view.View;

import com.eftimoff.udacitypopmovies.app.models.Movie;

public interface PostersFragmentActions {

    void onMovieClicked(final View view, final Movie movie);
}
