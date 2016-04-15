package com.eftimoff.udacitypopmovies.common.repository.retrofit;

import com.eftimoff.udacitypopmovies.common.repository.Repository;
import com.eftimoff.udacitypopmovies.common.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.common.repository.converters.MoviesConverter;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.MovieListDao;
import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.List;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Rx java here?
 * Created by georgieftimov on 07/04/16.
 */
public class RetrofitRepository implements Repository {

    private TheMovieDbApi theMovieDbApi;
    private MoviesConverter moviesConverter;

    @Inject
    public RetrofitRepository(final TheMovieDbApi theMovieDbApi, final MoviesConverter moviesConverter) {
        this.theMovieDbApi = theMovieDbApi;
        this.moviesConverter = moviesConverter;
    }

    @Override
    public void getPopularMovies(final RepositoryCallback<List<Movie>> callback) {
        theMovieDbApi.getPopularMovies(new Callback<MovieListDao>() {
            @Override
            public void success(MovieListDao movies, Response response) {
                callback.onSuccess(moviesConverter.convert(movies));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void getTopRatedMovies(final RepositoryCallback<List<Movie>> callback) {
        theMovieDbApi.getTopRatedMovies(new Callback<MovieListDao>() {
            @Override
            public void success(MovieListDao movies, Response response) {
                callback.onSuccess(moviesConverter.convert(movies));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }
}
