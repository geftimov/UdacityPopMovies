package com.eftimoff.udacitypopmovies.features.moviedetails.details.di;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.MovieDetailsView;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter.MovieDetailsPresenter;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter.MovieDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgieftimov on 08/04/16.
 */
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
