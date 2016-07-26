package com.eftimoff.udacitypopmovies.moviedetails.presenter;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;
import com.eftimoff.udacitypopmovies.app.repository.Repository;
import com.eftimoff.udacitypopmovies.app.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsView;

import java.util.List;

import javax.inject.Inject;

public class MovieDetailsPresenterImpl implements MovieDetailsPresenter {

    private MovieDetailsView movieDetailsView;
    private Repository repository;

    @Inject
    public MovieDetailsPresenterImpl(MovieDetailsView movieDetailsView, Repository repository) {
        this.movieDetailsView = movieDetailsView;
        this.repository = repository;
    }

    @Override
    public void getVideos(int movieId) {
        repository.getMoviesVideos(movieId, new RepositoryCallback<List<Video>>() {
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
        repository.getMoviesReviews(movieId, new RepositoryCallback<List<Review>>() {
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

    @Override
    public boolean isFavourite(int movieId) {
        return repository.isFavourite(movieId);
    }

    @Override
    public void saveFavourite(Movie movie, List<Review> review, List<Video> video) {
        repository.saveFavourite(movie, review, video);
    }

    @Override
    public void removeFavourite(Movie movie) {
        repository.removeFavourite(movie.getId());
    }
}
