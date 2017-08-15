package com.eftimoff.udacitypopmovies.app.repository;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;
import com.eftimoff.udacitypopmovies.app.repository.converters.MoviesConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.ReviewsConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.VideosConverter;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.TheMovieDbApi;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.models.MovieListDao;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.models.ReviewListDao;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.models.VideoListDao;
import com.eftimoff.udacitypopmovies.app.repository.storage.LocalStorage;

import java.util.List;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RepositoryImpl implements Repository {

    private TheMovieDbApi theMovieDbApi;
    private MoviesConverter moviesConverter;
    private VideosConverter videosConverter;
    private ReviewsConverter reviewsConverter;
    private LocalStorage localStorage;

    @Inject
    public RepositoryImpl(TheMovieDbApi theMovieDbApi, MoviesConverter moviesConverter, VideosConverter videosConverter, ReviewsConverter reviewsConverter, LocalStorage localStorage) {
        this.theMovieDbApi = theMovieDbApi;
        this.moviesConverter = moviesConverter;
        this.videosConverter = videosConverter;
        this.reviewsConverter = reviewsConverter;
        this.localStorage = localStorage;
    }

    @Override
    public void getPopularMovies(final RepositoryCallback<List<Movie>> callback) {
        theMovieDbApi.getPopularMovies(new Callback<MovieListDao>() {
            @Override
            public void success(MovieListDao movies, Response response) {
                callback.onSuccess(moviesConverter.convert(movies));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void getTopRatedMovies(final RepositoryCallback<List<Movie>> callback) {
        theMovieDbApi.getTopRatedMovies(new Callback<MovieListDao>() {
            @Override
            public void success(MovieListDao movies, Response response) {
                callback.onSuccess(moviesConverter.convert(movies));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void getMoviesVideos(final int movieId, final RepositoryCallback<List<Video>> callback) {
        theMovieDbApi.getMovieVideos(movieId, new Callback<VideoListDao>() {
            @Override
            public void success(final VideoListDao videoList, final Response response) {
                callback.onSuccess(videosConverter.convert(videoList));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public void getMoviesReviews(final int movieId, final RepositoryCallback<List<Review>> callback) {
        theMovieDbApi.getMovieReviews(movieId, new Callback<ReviewListDao>() {
            @Override
            public void success(ReviewListDao reviewListDao, Response response) {
                callback.onSuccess(reviewsConverter.convert(reviewListDao));
            }

            @Override
            public void failure(RetrofitError error) {
                callback.onError(error);
            }
        });
    }

    @Override
    public boolean isFavourite(int movieId) {
        return localStorage.isFavourite(movieId);
    }

    @Override
    public void saveFavourite(Movie movie, List<Review> review, List<Video> video) {
        localStorage.saveFavourite(movie);
    }

    @Override
    public void removeFavourite(int movieId) {
        localStorage.removeFavourite(movieId);
    }

    @Override
    public void getFavourites(RepositoryCallback<List<Movie>> callback) {
        callback.onSuccess(localStorage.getFavourites());
    }
}
