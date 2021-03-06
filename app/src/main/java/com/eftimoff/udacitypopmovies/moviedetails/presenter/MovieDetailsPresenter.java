package com.eftimoff.udacitypopmovies.moviedetails.presenter;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.List;

public interface MovieDetailsPresenter {

    void getVideos(final int movieId);

    void getReviews(final int movieId);

    boolean isFavourite(int movieId);

    void saveFavourite(Movie movie, List<Review> review, List<Video> video);

    void removeFavourite(Movie movie);

}
