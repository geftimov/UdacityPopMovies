package com.eftimoff.udacitypopmovies.favourites.di;

import com.eftimoff.udacitypopmovies.favourites.FavouritesActivity;

import dagger.Subcomponent;

@Subcomponent(modules = FavouritesModule.class)
public interface FavouritesComponent {

    void inject(FavouritesActivity activity);
}
