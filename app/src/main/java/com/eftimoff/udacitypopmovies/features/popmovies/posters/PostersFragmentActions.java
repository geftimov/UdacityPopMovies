package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import android.view.View;

import com.eftimoff.udacitypopmovies.models.Movie;

/**
 * Created by georgieftimov on 15/04/16.
 */
public interface PostersFragmentActions {

    void onMovieClicked(final View view, final Movie movie);
}
