package com.eftimoff.udacitypopmovies.common.repository.converters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieGenreHelper {

    private Map<Integer, String> genres = new HashMap<>();

    public MovieGenreHelper() {
        genres.put(28, "Action");
        genres.put(12, "Adventure");
        genres.put(16, "Animation");
        genres.put(35, "Comedy");
        genres.put(80, "Crime");
        genres.put(99, "Documentary");
        genres.put(18, "Drama");
        genres.put(10751, "Family");
        genres.put(14, "Fantasy");
        genres.put(10769, "Foreign");
        genres.put(36, "History");
        genres.put(27, "Horror");
        genres.put(10402, "Music");
        genres.put(9648, "Mystery");
        genres.put(10749, "Romance");
        genres.put(878, "Science Fiction");
        genres.put(10770, "TB Movie");
        genres.put(53, "Thriller");
        genres.put(10752, "War");
        genres.put(37, "Western");
    }

    public List<String> fromIdsToList(List<Integer> genreIds) {
        final List<String> genreList = new ArrayList<>();
        for (int i = 0; i < genreIds.size(); i++) {
            final Integer id = genreIds.get(i);
            final String genre = genres.get(id);
            if (genre == null) {
                //not existing
                continue;
            }
            genreList.add(genre);
        }
        return genreList;
    }

    public String fromIds(List<Integer> genreIds) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < genreIds.size(); i++) {
            final Integer id = genreIds.get(i);
            final String genre = genres.get(id);
            if (genre == null) {
                //not existing
                continue;
            }
            stringBuilder.append(genre);
            if (i != genreIds.size() - 1) {
                stringBuilder.append(" , ");
            }
        }
        return stringBuilder.toString();
    }
}
