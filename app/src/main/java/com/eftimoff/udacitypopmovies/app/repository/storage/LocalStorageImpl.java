package com.eftimoff.udacitypopmovies.app.repository.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class LocalStorageImpl implements LocalStorage {

    public static final String KEY_FAVOURITES = "favourites";

    private SharedPreferences sharedPreferences;
    private Gson gson = new Gson();

    public LocalStorageImpl(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    @Nullable
    public MovieWrapper getFavourite(int movieId) {
        final Map<Integer, MovieWrapper> favourites = getFavourites();
        return favourites.get(movieId);
    }

    @Override
    @NonNull
    public Map<Integer, MovieWrapper> getFavourites() {
        Map<Integer, MovieWrapper> map;
        final String mapString = sharedPreferences.getString(KEY_FAVOURITES, null);
        if (mapString == null) {
            map = new HashMap<>();
        } else {
            java.lang.reflect.Type type = new TypeToken<HashMap<Integer, MovieWrapper>>() {
            }.getType();
            map = gson.fromJson(mapString, type);
        }
        return map;
    }

    @Override
    public void saveFavourite(MovieWrapper movieWrapper) {
        final Map<Integer, MovieWrapper> favourites = getFavourites();
        favourites.put(movieWrapper.getId(), movieWrapper);
        final String json = gson.toJson(favourites);
        sharedPreferences.edit().putString(KEY_FAVOURITES, json).apply();
    }

    @Override
    public void removeFavourite(int movieId) {
        final Map<Integer, MovieWrapper> favourites = getFavourites();
        favourites.remove(movieId);
        final String json = gson.toJson(favourites);
        sharedPreferences.edit().putString(KEY_FAVOURITES, json).apply();
    }
}
