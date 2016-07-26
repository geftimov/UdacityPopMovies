package com.eftimoff.udacitypopmovies.moviedetails.presenter;

import com.eftimoff.udacitypopmovies.app.models.Movie;

public interface MovieDetailsPresenter {

    void getVideos(final int movieId);

    void getReviews(final int movieId);

    boolean isFavourite(int movieId);

    void saveFavourite(Movie movie);

    void removeFavourite(Movie movie);

}
