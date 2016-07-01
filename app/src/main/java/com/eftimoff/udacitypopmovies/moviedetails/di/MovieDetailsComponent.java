package com.eftimoff.udacitypopmovies.moviedetails.di;

import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsActivity;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = MovieDetailsModule.class)
public interface MovieDetailsComponent {

    void inject(final MovieDetailsFragment movieDetailsFragment);

    void inject(final MovieDetailsActivity movieDetailsActivity);

}
