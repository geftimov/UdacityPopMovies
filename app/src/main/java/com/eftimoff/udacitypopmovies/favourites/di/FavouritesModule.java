package com.eftimoff.udacitypopmovies.favourites.di;

import com.eftimoff.udacitypopmovies.favourites.FavouritesActivity;
import com.eftimoff.udacitypopmovies.favourites.FavouritesView;
import com.eftimoff.udacitypopmovies.favourites.presenter.FavouritesPresenter;
import com.eftimoff.udacitypopmovies.favourites.presenter.FavouritesPresenterImpl;
import com.eftimoff.udacitypopmovies.popmovies.posters.adapter.PostersAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class FavouritesModule {

    private FavouritesActivity favouritesActivity;

    public FavouritesModule(FavouritesActivity favouritesActivity) {
        this.favouritesActivity = favouritesActivity;
    }

    @Provides
    PostersAdapter providePostersAdapter() {
        return new PostersAdapter(null);
    }

    @Provides
    FavouritesView provideFavouritesView() {
        return favouritesActivity;
    }

    @Provides
    FavouritesPresenter provideFavouritesPresenter(final FavouritesPresenterImpl favouritesPresenter) {
        return favouritesPresenter;
    }

}
