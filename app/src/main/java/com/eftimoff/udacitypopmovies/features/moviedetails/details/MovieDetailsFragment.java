package com.eftimoff.udacitypopmovies.features.moviedetails.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseFragment;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter.MovieDetailsPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by georgieftimov on 06/04/16.
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

    @Inject
    MovieDetailsPresenter movieDetailsPresenter;

    public static MovieDetailsFragment newInstance() {
        return new MovieDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void injectDependencies() {

    }
}
