package com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter;

import com.eftimoff.udacitypopmovies.common.repository.RepositoryCallback;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.MovieDetailsView;
import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by georgieftimov on 07/04/16.
 */
public class MovieDetailsPresenterImpl implements MovieDetailsPresenter {

    private MovieDetailsView movieDetailsView;
    private RetrofitRepository retrofitRepository;

    @Inject
    public MovieDetailsPresenterImpl(MovieDetailsView movieDetailsView, RetrofitRepository retrofitRepository) {
        this.movieDetailsView = movieDetailsView;
        this.retrofitRepository = retrofitRepository;
    }
}
