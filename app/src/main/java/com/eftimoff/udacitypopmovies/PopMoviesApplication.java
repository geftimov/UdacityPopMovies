package com.eftimoff.udacitypopmovies;

import android.app.Application;

import com.eftimoff.udacitypopmovies.app.di.DaggerPopMoviesComponent;
import com.eftimoff.udacitypopmovies.app.di.PopMovieModule;
import com.eftimoff.udacitypopmovies.app.di.PopMoviesComponent;

public class PopMoviesApplication extends Application {

    private static PopMoviesComponent popMoviesComponent;

    public static PopMoviesComponent getComponent() {
        return popMoviesComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        popMoviesComponent = DaggerPopMoviesComponent.builder()
                .popMovieModule(new PopMovieModule(this))
                .build();
    }
}
