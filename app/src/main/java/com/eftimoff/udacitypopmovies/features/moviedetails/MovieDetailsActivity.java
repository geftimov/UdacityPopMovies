package com.eftimoff.udacitypopmovies.features.moviedetails;

import android.os.Bundle;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseActivity;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.MovieDetailsFragment;

public class MovieDetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        if (savedInstanceState == null) {
            startFragment(MovieDetailsFragment.newInstance(), R.id.container);
        }
    }

    @Override
    public void injectDependencies() {

    }
}
