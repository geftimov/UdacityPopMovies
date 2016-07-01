package com.eftimoff.udacitypopmovies.app.di;

import android.content.Context;

import com.eftimoff.udacitypopmovies.app.utils.VideoHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class PopMovieModule {

    private Context context;

    public PopMovieModule(Context context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    VideoHelper provideVideoHelper() {
        return new VideoHelper(context);
    }
}
