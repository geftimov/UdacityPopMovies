package com.eftimoff.udacitypopmovies.app.repository;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.List;

public interface Repository {

    void getPopularMovies(final RepositoryCallback<List<Movie>> callback);

    void getTopRatedMovies(final RepositoryCallback<List<Movie>> callback);

    void getMoviesVideos(final int movieId, final RepositoryCallback<List<Video>> callback);

    void getMoviesReviews(final int movieId, final RepositoryCallback<List<Review>> callback);

    boolean isFavourite(int movieId);

    void saveFavourite(Movie movie, List<Review> review, List<Video> video);

    void removeFavourite(int movieId);
}
