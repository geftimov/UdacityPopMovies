package com.eftimoff.udacitypopmovies.features.moviedetails.di;

import com.eftimoff.udacitypopmovies.features.moviedetails.MovieDetailsActivity;
import com.eftimoff.udacitypopmovies.features.moviedetails.MovieDetailsFragment;

import dagger.Subcomponent;

/**
 * Created by georgieftimov on 08/04/16.
 */
@Subcomponent(modules = MovieDetailsModule.class)
public interface MovieDetailsComponent {

    void inject(final MovieDetailsFragment movieDetailsFragment);

    void inject(final MovieDetailsActivity movieDetailsActivity);

}