package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseFragment;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter.PosterAdapterListener;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter.PostersAdapter;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.di.PostersModule;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.presenter.PostersPresenter;
import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostersFragment extends BaseFragment implements PostersView, PosterAdapterListener {

    private static final String STATE_ITEMS = "items";

    @BindView(R.id.postersRecyclerView)
    RecyclerView postersRecyclerView;

    @Inject
    PostersPresenter postersPresenter;
    @Inject
    PostersAdapter postersAdapter;

    private PostersFragmentActions postersFragmentActions;

    public static PostersFragment newInstance() {
        return new PostersFragment();
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication.getComponent()
                .plus(new PostersModule(this))
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_posters, container, false);
        ButterKnife.bind(this, view);
        postersRecyclerView.setHasFixedSize(true);
        postersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), getResources().getInteger(R.integer.pop_movies_column_number)));
        postersRecyclerView.setAdapter(postersAdapter);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            postersAdapter.setMovies((List<Movie>) savedInstanceState.getSerializable(STATE_ITEMS));
        } else {
            postersPresenter.getPopularMovies();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof PostersFragmentActions) {
            postersFragmentActions = (PostersFragmentActions) activity;
        }
    }

    @Override
    public void onMoviesSuccess(List<Movie> movies) {
        postersAdapter.setMovies(movies);
    }

    @Override
    public void onMoviesError(final String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onMovieClicked(final View view, final Movie movie) {
        postersFragmentActions.onMovieClicked(view, movie);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_ITEMS, (ArrayList) postersAdapter.getItems());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.movies_menu_sort_top:
                onMoviesTopClick();
                break;
            case R.id.movies_menu_sort_popular:
                onMoviesPopularClick();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    private void onMoviesPopularClick() {
        postersPresenter.getPopularMovies();
    }

    private void onMoviesTopClick() {
        postersPresenter.getTopRatedMovies();
    }
}
