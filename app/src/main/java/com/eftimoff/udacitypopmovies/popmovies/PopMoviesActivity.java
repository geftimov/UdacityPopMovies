package com.eftimoff.udacitypopmovies.popmovies;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.BaseActivity;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsActivity;
import com.eftimoff.udacitypopmovies.moviedetails.MovieDetailsFragment;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersFragment;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersFragmentActions;
import com.eftimoff.udacitypopmovies.app.models.Movie;

import butterknife.BindBool;
import butterknife.ButterKnife;

public class PopMoviesActivity extends BaseActivity implements PostersFragmentActions {

    @BindBool(R.bool.is_master_detail_flow)
    boolean isMasterDetailFlow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_movies);
        ButterKnife.bind(this);
        startFragment(PostersFragment.newInstance(), R.id.container);
    }

    @Override
    public void injectDependencies() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies_menu, menu);
        return true;
    }

    @Override
    public void onMovieClicked(View view, Movie movie) {
        if (isMasterDetailFlow) {
            startFragment(MovieDetailsFragment.newInstance(movie), R.id.rightContainer);
        } else {
            final Intent intent = MovieDetailsActivity.getIntent(this, movie);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, view, getString(R.string.poster_transition_name));
                startActivity(intent, options.toBundle());
                return;
            }

            startActivity(intent);
        }
    }
}
