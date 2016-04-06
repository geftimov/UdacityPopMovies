package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.common.BaseFragment;
import com.eftimoff.udacitypopmovies.features.popmovies.posters.di.PostersModule;

/**
 * Created by georgieftimov on 06/04/16.
 */
public class PostersFragment extends BaseFragment {

    public static PostersFragment newInstance() {
        return new PostersFragment();
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication.getComponent()
                .plus(new PostersModule())
                .inject(this);
    }
}
