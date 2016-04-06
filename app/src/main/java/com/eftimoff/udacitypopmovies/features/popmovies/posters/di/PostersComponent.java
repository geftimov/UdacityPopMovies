package com.eftimoff.udacitypopmovies.features.popmovies.posters.di;

import com.eftimoff.udacitypopmovies.features.popmovies.posters.PostersFragment;

import dagger.Subcomponent;

/**
 * Created by georgieftimov on 06/04/16.
 */
@Subcomponent(modules = PostersModule.class)
public interface PostersComponent {

    void inject(PostersFragment fragment);
}
