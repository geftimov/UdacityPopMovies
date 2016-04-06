package com.eftimoff.udacitypopmovies.common;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    public abstract void injectDependencies();
    
    public void startFragment(final Fragment fragment, @IdRes final int containerResourceId) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerResourceId, fragment)
                .commit();
    }
}
