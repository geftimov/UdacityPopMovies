package com.eftimoff.udacitypopmovies.common.repository.retrofit;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.MovieListDao;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by georgieftimov on 07/04/16.
 */
public interface TheMovieDbApi {

    @GET("/3/movie/popular")
    void getPopularMovies(final Callback<MovieListDao> callback);

    @GET("/3/movie/top_rated")
    void getTopRatedMovies(final Callback<MovieListDao> callback);
}
