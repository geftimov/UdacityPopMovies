package com.eftimoff.udacitypopmovies.features.moviedetails.presenter;

/**
 * Created by georgieftimov on 07/04/16.
 */
public interface MovieDetailsPresenter {

    void getVideos(final int movieId);

    void getReviews(final int movieId);

}
