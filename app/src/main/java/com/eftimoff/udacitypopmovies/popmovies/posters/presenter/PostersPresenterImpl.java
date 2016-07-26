package com.eftimoff.udacitypopmovies.popmovies.posters.presenter;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.app.repository.RepositoryImpl;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersView;
import com.eftimoff.udacitypopmovies.app.models.Movie;

import java.util.List;

import javax.inject.Inject;

public class PostersPresenterImpl implements PostersPresenter {

    private PostersView postersView;
    private RepositoryImpl repositoryImpl;

    @Inject
    public PostersPresenterImpl(final PostersView postersView, final RepositoryImpl repositoryImpl) {
        this.postersView = postersView;
        this.repositoryImpl = repositoryImpl;
    }

    @Override
    public void getPopularMovies() {
        repositoryImpl.getPopularMovies(new RepositoryCallback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                postersView.onMoviesSuccess(movies);
            }

            @Override
            public void onError(Throwable throwable) {
                postersView.onMoviesError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getTopRatedMovies() {
        repositoryImpl.getTopRatedMovies(new RepositoryCallback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                postersView.onMoviesSuccess(movies);
            }

            @Override
            public void onError(Throwable throwable) {
                postersView.onMoviesError(throwable.getMessage());
            }
        });
    }
}
