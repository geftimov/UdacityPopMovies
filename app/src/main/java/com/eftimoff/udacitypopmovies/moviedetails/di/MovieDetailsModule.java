package com.eftimoff.udacitypopmovies.moviedetails.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsView;
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

    public MovieDetailsModule(MovieDetailsView movieDetailsView, VideoAdapterListener videoAdapterListener) {
        this.movieDetailsView = movieDetailsView;
        this.videoAdapterListener = videoAdapterListener;
    }

    @Provides
    MovieDetailsPresenter providePostersPresenter(final RetrofitRepository retrofitRepository) {
        return new MovieDetailsPresenterImpl(movieDetailsView, retrofitRepository);
    }

    @Provides
    RecyclerView.LayoutManager provideLayoutManager(final Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    VideoAdapter provideVideoAdapter() {
        return new VideoAdapter(videoAdapterListener);
    }
}
