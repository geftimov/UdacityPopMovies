package com.eftimoff.udacitypopmovies.app.di;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryModule;
import com.eftimoff.udacitypopmovies.moviedetails.di.MovieDetailsComponent;
import com.eftimoff.udacitypopmovies.moviedetails.di.MovieDetailsModule;
import com.eftimoff.udacitypopmovies.popmovies.posters.di.PostersComponent;
import com.eftimoff.udacitypopmovies.popmovies.posters.di.PostersModule;

import dagger.Component;

@Component(modules = {PopMovieModule.class, RepositoryModule.class})
public interface PopMoviesComponent {

    PostersComponent plus(final PostersModule postersModule);

    MovieDetailsComponent plus(final MovieDetailsModule postersModule);


}
