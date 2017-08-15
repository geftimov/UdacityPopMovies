package com.eftimoff.udacitypopmovies.app.repository.storage;

import com.eftimoff.udacitypopmovies.app.models.Movie;

import java.util.List;

public interface LocalStorage {

    boolean isFavourite(int movieId);

    List<Movie> getFavourites();

    void saveFavourite(Movie movie);

    void removeFavourite(int movieId);
}
