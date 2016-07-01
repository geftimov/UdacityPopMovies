package com.eftimoff.udacitypopmovies.moviedetails.presenter;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsView;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.List;

import javax.inject.Inject;

public class MovieDetailsPresenterImpl implements MovieDetailsPresenter {

    private MovieDetailsView movieDetailsView;
    private RetrofitRepository retrofitRepository;

    @Inject
    public MovieDetailsPresenterImpl(MovieDetailsView movieDetailsView, RetrofitRepository retrofitRepository) {
        this.movieDetailsView = movieDetailsView;
        this.retrofitRepository = retrofitRepository;
    }

    @Override
    public void getVideos(int movieId) {
        retrofitRepository.getMoviesVideos(movieId, new RepositoryCallback<List<Video>>() {
            @Override
            public void onSuccess(List<Video> videos) {
                movieDetailsView.onVideoSuccess(videos);
            }

            @Override
            public void onError(Throwable throwable) {
                movieDetailsView.onVideoError(throwable.getMessage());
            }
        });
    }

    @Override
    public void getReviews(int movieId) {
        retrofitRepository.getMoviesReviews(movieId, new RepositoryCallback<List<Review>>() {
            @Override
            public void onSuccess(List<Review> reviews) {
                movieDetailsView.onReviewsSuccess(reviews);
            }

            @Override
            public void onError(Throwable throwable) {
                movieDetailsView.onReviewsError(throwable.getMessage());
            }
        });
    }
}
