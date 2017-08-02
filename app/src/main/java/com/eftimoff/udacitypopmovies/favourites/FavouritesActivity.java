package com.eftimoff.udacitypopmovies.favourites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.BaseActivity;
import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.favourites.di.FavouritesModule;
import com.eftimoff.udacitypopmovies.favourites.presenter.FavouritesPresenter;
import com.eftimoff.udacitypopmovies.popmovies.posters.adapter.PostersAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FavouritesActivity extends BaseActivity implements FavouritesView {

    @BindView(R.id.favouritesRecyclerView)
    RecyclerView favouritesRecyclerView;

    @Inject
    PostersAdapter postersAdapter;
    @Inject
    FavouritesPresenter favouritesPresenter;

    public static void start(Context context) {
        Intent starter = new Intent(context, FavouritesActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        ButterKnife.bind(this);

        favouritesRecyclerView.setHasFixedSize(true);
        favouritesRecyclerView.setLayoutManager(new GridLayoutManager(this, getResources().getInteger(R.integer.favourites_column_number)));
        favouritesRecyclerView.setAdapter(postersAdapter);

        favouritesPresenter.getFavouritesMovies();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication.getComponent()
                .plus(new FavouritesModule(this))
                .inject(this);
    }

    @Override
    public void onMoviesSuccess(List<Movie> movies) {
        postersAdapter.setMovies(movies);
    }

    @Override
    public void onMoviesError(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
