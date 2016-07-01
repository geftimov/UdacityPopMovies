package com.eftimoff.udacitypopmovies.common.repository.retrofit;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.MovieListDao;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.ReviewListDao;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.VideoListDao;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface TheMovieDbApi {

    @GET("/3/movie/popular")
    void getPopularMovies(final Callback<MovieListDao> callback);

    @GET("/3/movie/top_rated")
    void getTopRatedMovies(final Callback<MovieListDao> callback);

    @GET("/3/movie/{id}/videos")
    void getMovieVideos(@Path("id") final int id, final Callback<VideoListDao> callback);

    @GET("/3/movie/{id}/reviews")
    void getMovieReviews(@Path("id") final int id, final Callback<ReviewListDao> callback);
}
