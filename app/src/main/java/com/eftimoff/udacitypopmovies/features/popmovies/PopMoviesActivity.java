package com.eftimoff.udacitypopmovies.features.popmovies;

import android.os.Bundle;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseActivity;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.PostersFragment;

public class PopMoviesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_movies);
        if (savedInstanceState == null) {
            startFragment(PostersFragment.newInstance(), R.id.container);
        }
    }

    @Override
    public void injectDependencies() {

    }
}
