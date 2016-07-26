package com.eftimoff.udacitypopmovies.moviedetails.di;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryImpl;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsView;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.ReviewAdapter;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.ReviewAdapterListener;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.VideoAdapter;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.VideoAdapterListener;
import com.eftimoff.udacitypopmovies.moviedetails.presenter.MovieDetailsPresenter;
import com.eftimoff.udacitypopmovies.moviedetails.presenter.MovieDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailsModule {

    private MovieDetailsView movieDetailsView;
    private VideoAdapterListener videoAdapterListener;
    private ReviewAdapterListener reviewAdapterListener;

    public MovieDetailsModule(MovieDetailsView movieDetailsView, VideoAdapterListener videoAdapterListener, ReviewAdapterListener reviewAdapterListener) {
        this.movieDetailsView = movieDetailsView;
        this.videoAdapterListener = videoAdapterListener;
        this.reviewAdapterListener = reviewAdapterListener;
    }

    @Provides
    MovieDetailsPresenter providePostersPresenter(final RepositoryImpl repositoryImpl) {
        return new MovieDetailsPresenterImpl(movieDetailsView, repositoryImpl);
    }

    @Provides
    VideoAdapter provideVideoAdapter() {
        return new VideoAdapter(videoAdapterListener);
    }

    @Provides
    ReviewAdapter provideReviewAdapter() {
        return new ReviewAdapter(reviewAdapterListener);
    }
}
