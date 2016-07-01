package com.eftimoff.udacitypopmovies.app.di;

import android.content.Context;

import dagger.Module;

@Module
public class PopMovieModule {

    private Context context;

    public PopMovieModule(Context context) {
        this.context = context;
    }
}
