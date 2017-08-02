package com.eftimoff.udacitypopmovies.favourites.presenter;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.repository.Repository;
import com.eftimoff.udacitypopmovies.app.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.favourites.FavouritesView;

import java.util.List;

import javax.inject.Inject;

public class FavouritesPresenterImpl implements FavouritesPresenter {

    private FavouritesView favouritesView;
    private Repository repository;

    @Inject
    public FavouritesPresenterImpl(final FavouritesView favouritesView, final Repository repository) {
        this.favouritesView = favouritesView;
        this.repository = repository;
    }

    @Override
    public void getFavouritesMovies() {
        repository.getFavourites(new RepositoryCallback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                favouritesView.onMoviesSuccess(movies);
            }

            @Override
            public void onError(Throwable throwable) {
                favouritesView.onMoviesError(throwable.getMessage());
            }
        });
    }
}
