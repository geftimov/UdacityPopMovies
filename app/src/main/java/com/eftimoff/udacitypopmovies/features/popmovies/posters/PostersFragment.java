package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseFragment;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.di.PostersModule;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.presenter.PostersPresenter;
import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by georgieftimov on 06/04/16.
 */
public class PostersFragment extends BaseFragment implements PostersView {

    @Bind(R.id.postersRecyclerView)
    RecyclerView postersRecyclerView;

    @Inject
    PostersPresenter postersPresenter;
    @Inject
    PostersAdapter postersAdapter;

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
        postersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        postersRecyclerView.setAdapter(postersAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postersPresenter.getPopularMovies();
    }

    @Override
    public void onMoviesSuccess(List<Movie> movies) {
        postersAdapter.setMovies(movies);
    }

    @Override
    public void onMoviesError(final String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }
}
