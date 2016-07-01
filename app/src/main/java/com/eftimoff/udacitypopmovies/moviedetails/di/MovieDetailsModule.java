package com.eftimoff.udacitypopmovies.moviedetails.di;

import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsView;
import com.eftimoff.udacitypopmovies.moviedetails.presenter.MovieDetailsPresenter;
import com.eftimoff.udacitypopmovies.moviedetails.presenter.MovieDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailsModule {

    private MovieDetailsView movieDetailsView;

    public MovieDetailsModule(MovieDetailsView movieDetailsView) {
        this.movieDetailsView = movieDetailsView;
    }

    @Provides
    MovieDetailsPresenter providePostersPresenter(final RetrofitRepository retrofitRepository) {
        return new MovieDetailsPresenterImpl(movieDetailsView, retrofitRepository);
    }
}
