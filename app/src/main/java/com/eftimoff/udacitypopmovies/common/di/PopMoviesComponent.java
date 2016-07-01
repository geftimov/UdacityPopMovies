package com.eftimoff.udacitypopmovies.common.di;

import com.eftimoff.udacitypopmovies.common.repository.RepositoryModule;
import com.eftimoff.udacitypopmovies.features.moviedetails.di.MovieDetailsComponent;
import com.eftimoff.udacitypopmovies.features.moviedetails.di.MovieDetailsModule;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.di.PostersComponent;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.di.PostersModule;

import dagger.Component;

@Component(modules = {PopMovieModule.class, RepositoryModule.class})
public interface PopMoviesComponent {

    PostersComponent plus(final PostersModule postersModule);

    MovieDetailsComponent plus(final MovieDetailsModule postersModule);


}
