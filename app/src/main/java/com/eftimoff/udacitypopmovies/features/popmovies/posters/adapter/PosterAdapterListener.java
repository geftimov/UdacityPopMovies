package com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter;

import android.view.View;

import com.eftimoff.udacitypopmovies.models.Movie;

public interface PosterAdapterListener {

    void onMovieClicked(final View view, final Movie movie);
}
