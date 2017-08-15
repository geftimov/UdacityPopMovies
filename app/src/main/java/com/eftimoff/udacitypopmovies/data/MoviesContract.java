package com.eftimoff.udacitypopmovies.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public final class MoviesContract {

    public static final String CONTENT_AUTHORITY = "com.eftimoff.udacitypopmovies";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FAVORITES = "favorites";

    public static final String COLUMN_MOVIE_ID_KEY = "_id";

    private MoviesContract() {
    }

    public static final class FavouriteEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVORITES).build();

        public static final String CONTENT_DIR_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITES;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITES;

        public static final String TABLE_NAME = "movies";

        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_IMAGE_URL = "image_url";
        public static final String COLUMN_SCORE = "score";
        public static final String COLUMN_GENRES = "genres";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_RELEASE_DATE + " TEXT, " +
                        COLUMN_IMAGE_URL + " TEXT, " +
                        COLUMN_SCORE + " REAL, " +
                        COLUMN_GENRES + " REAL" +
                        " );";

        private static final String[] COLUMNS = {_ID, COLUMN_DESCRIPTION, COLUMN_RELEASE_DATE,
                COLUMN_IMAGE_URL, COLUMN_SCORE, COLUMN_TITLE, COLUMN_GENRES};


        private FavouriteEntry() {
        }

        public static Uri buildMovieUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static long getIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }

        public static String[] getColumns() {
            return COLUMNS.clone();
        }
    }
}