package com.eftimoff.udacitypopmovies.features.moviedetails.details;

import com.eftimoff.udacitypopmovies.models.Review;
import com.eftimoff.udacitypopmovies.models.Video;

import java.util.List;

/**
 * Created by georgieftimov on 07/04/16.
 */
public interface MovieDetailsView {

    void onVideoSuccess(List<Video> videos);

    void onVideoError(String message);

    void onReviewsSuccess(List<Review> reviews);

    void onReviewsError(String message);
}
