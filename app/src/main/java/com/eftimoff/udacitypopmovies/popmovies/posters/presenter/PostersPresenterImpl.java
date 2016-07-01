package com.eftimoff.udacitypopmovies.popmovies.posters.presenter;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersView;
import com.eftimoff.udacitypopmovies.app.models.Movie;

import java.util.List;

import javax.inject.Inject;

public class PostersPresenterImpl implements PostersPresenter {

    private PostersView postersView;
    private RetrofitRepository retrofitRepository;

    @Inject
    public PostersPresenterImpl(final PostersView postersView, final RetrofitRepository retrofitRepository) {
        this.postersView = postersView;
        this.retrofitRepository = retrofitRepository;
    }

    @Override
    public void getPopularMovies() {
        retrofitRepository.getPopularMovies(new RepositoryCallback<List<Movie>>() {
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
        retrofitRepository.getTopRatedMovies(new RepositoryCallback<List<Movie>>() {
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
