package com.eftimoff.udacitypopmovies.common.repository;

import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.List;

/**
 * Created by georgieftimov on 07/04/16.
 */
public interface Repository {

    void getPopularMovies(final RepositoryCallback<List<Movie>> callback);

    void getTopRatedMovies(final RepositoryCallback<List<Movie>> callback);
}
