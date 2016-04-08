package com.eftimoff.udacitypopmovies.features.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.PostersFragment;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.adapter.PostersAdapter;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.PostersView;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.presenter.PostersPresenter;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.presenter.PostersPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by georgieftimov on 06/04/16.
 */
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
