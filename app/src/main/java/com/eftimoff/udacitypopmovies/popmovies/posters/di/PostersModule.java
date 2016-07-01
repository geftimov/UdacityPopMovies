package com.eftimoff.udacitypopmovies.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersFragment;
import com.eftimoff.udacitypopmovies.popmovies.posters.adapter.PostersAdapter;
import com.eftimoff.udacitypopmovies.popmovies.posters.presenter.PostersPresenter;
import com.eftimoff.udacitypopmovies.popmovies.posters.presenter.PostersPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PostersModule {

    private PostersFragment postersFragment;

    public PostersModule(PostersFragment postersFragment) {
        this.postersFragment = postersFragment;
    }

    @Provides
    PostersAdapter providePostersAdapter() {
        return new PostersAdapter(postersFragment);
    }

    @Provides
    PostersPresenter providePostersPresenter(final RetrofitRepository retrofitRepository) {
        return new PostersPresenterImpl(postersFragment, retrofitRepository);
    }

}
