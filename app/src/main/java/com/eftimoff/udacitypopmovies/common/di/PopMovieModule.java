package com.eftimoff.udacitypopmovies.common.di;

import android.content.Context;

import dagger.Module;

/**
 * Created by georgieftimov on 06/04/16.
 */
@Module
public class PopMovieModule {

    private Context context;

    public PopMovieModule(Context context) {
        this.context = context;
    }
}
