package com.eftimoff.udacitypopmovies.popmovies.posters.adapter;

import android.view.View;

import com.eftimoff.udacitypopmovies.app.models.Movie;

public interface PosterAdapterListener {

    void onMovieClicked(final View view, final Movie movie);
}
