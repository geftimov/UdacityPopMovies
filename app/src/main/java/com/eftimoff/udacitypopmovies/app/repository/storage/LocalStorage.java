package com.eftimoff.udacitypopmovies.app.repository.storage;

import java.util.Map;

public interface LocalStorage {

    MovieWrapper getFavourite(int movieId);

    Map<Integer, MovieWrapper> getFavourites();

    void saveFavourite(MovieWrapper movieWrapper);

    void removeFavourite(int movieId);
}
