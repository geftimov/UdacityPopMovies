package com.eftimoff.udacitypopmovies.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.app.repository.RepositoryImpl;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersFragment;
import com.eftimoff.udacitypopmovies.popmovies.posters.PostersView;
import com.eftimoff.udacitypopmovies.popmovies.posters.adapter.PosterAdapterListener;
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
    PosterAdapterListener providePosterAdapterListener() {
        return postersFragment;
    }

    @Provides
    PostersAdapter providePostersAdapter(PosterAdapterListener posterAdapterListener) {
        return new PostersAdapter(posterAdapterListener);
    }

    @Provides
    PostersView providePostersView() {
        return postersFragment;
    }

    @Provides
    PostersPresenter providePostersPresenter(final PostersView postersView, final RepositoryImpl repositoryImpl) {
        return new PostersPresenterImpl(postersView, repositoryImpl);
    }

}
