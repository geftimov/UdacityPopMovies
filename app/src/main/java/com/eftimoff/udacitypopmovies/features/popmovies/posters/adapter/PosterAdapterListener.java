package com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter;

import android.view.View;

import com.eftimoff.udacitypopmovies.models.Movie;

/**
 * Created by georgieftimov on 08/04/16.
 */
public interface PosterAdapterListener {

    void onMovieClicked(final View view,final Movie movie);
}
