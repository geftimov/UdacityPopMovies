package com.eftimoff.udacitypopmovies.features.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.PostersAdapter;
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

    private PostersView postersView;

    public PostersModule(PostersView postersView) {
        this.postersView = postersView;
    }

    @Provides
    PostersAdapter providePostersAdapter() {
        return new PostersAdapter();
    }

    @Provides
    PostersPresenter providePostersPresenter(final RetrofitRepository retrofitRepository) {
        return new PostersPresenterImpl(postersView, retrofitRepository);
    }

}
