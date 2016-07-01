package com.eftimoff.udacitypopmovies.moviedetails;

import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.List;

public interface MovieDetailsView {

    void onVideoSuccess(List<Video> videos);

    void onVideoError(String message);

    void onReviewsSuccess(List<Review> reviews);

    void onReviewsError(String message);
}
