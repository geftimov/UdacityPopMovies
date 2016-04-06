package com.eftimoff.udacitypopmovies;

import android.app.Application;

import com.eftimoff.udacitypopmovies.common.di.DaggerPopMoviesComponent;
import com.eftimoff.udacitypopmovies.common.di.PopMovieModule;
import com.eftimoff.udacitypopmovies.common.di.PopMoviesComponent;

/**
 * Created by georgieftimov on 06/04/16.
 */
public class PopMoviesApplication extends Application {

    private static PopMoviesComponent popMoviesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        popMoviesComponent = DaggerPopMoviesComponent.builder()
                .popMovieModule(new PopMovieModule(this))
                .build();
    }

    public static PopMoviesComponent getComponent() {
        return popMoviesComponent;
    }
}
