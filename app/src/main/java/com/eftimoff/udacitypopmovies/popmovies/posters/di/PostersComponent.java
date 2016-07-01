package com.eftimoff.udacitypopmovies.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.popmovies.posters.PostersFragment;

import dagger.Subcomponent;

@Subcomponent(modules = PostersModule.class)
public interface PostersComponent {

    void inject(PostersFragment fragment);
}
