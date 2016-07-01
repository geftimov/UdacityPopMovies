package com.eftimoff.udacitypopmovies.common.repository;

import com.eftimoff.udacitypopmovies.models.Movie;
import com.eftimoff.udacitypopmovies.models.Review;
import com.eftimoff.udacitypopmovies.models.Video;

import java.util.List;

public interface Repository {

    void getPopularMovies(final RepositoryCallback<List<Movie>> callback);

    void getTopRatedMovies(final RepositoryCallback<List<Movie>> callback);

    void getMoviesVideos(final int movieId, final RepositoryCallback<List<Video>> callback);

    void getMoviesReviews(final int movieId, final RepositoryCallback<List<Review>> callback);
}
