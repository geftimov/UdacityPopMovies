package com.eftimoff.udacitypopmovies.app.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.eftimoff.udacitypopmovies.data.MoviesContract;

import java.util.Arrays;
import java.util.List;

public class Movie implements Parcelable {

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private int id;
    private String title;
    private String imageUrl;
    private String releaseDate;
    private float score;
    private String genres;
    private List<String> genreList;
    private String description;


    public Movie() {
    }

    public Movie(Cursor cursor) {
        id = cursor.getInt(cursor.getColumnIndex(MoviesContract.FavouriteEntry._ID));
        title = cursor.getString(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_TITLE));
        imageUrl = cursor.getString(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_IMAGE_URL));
        releaseDate = cursor.getString(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_RELEASE_DATE));
        score = cursor.getFloat(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_SCORE));
        genres = cursor.getString(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_GENRES));
        description = cursor.getString(cursor.getColumnIndex(MoviesContract.FavouriteEntry.COLUMN_DESCRIPTION));
        genreList = Arrays.asList(TextUtils.split(genres, " , "));
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        imageUrl = in.readString();
        releaseDate = in.readString();
        score = in.readFloat();
        genres = in.readString();
        genreList = in.createStringArrayList();
        description = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public List<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<String> genreList) {
        this.genreList = genreList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (Float.compare(movie.score, score) != 0) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (imageUrl != null ? !imageUrl.equals(movie.imageUrl) : movie.imageUrl != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null)
            return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;
        if (genreList != null ? !genreList.equals(movie.genreList) : movie.genreList != null)
            return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (score != +0.0f ? Float.floatToIntBits(score) : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (genreList != null ? genreList.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", score=" + score +
                ", genres='" + genres + '\'' +
                ", genreList=" + genreList +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(releaseDate);
        dest.writeFloat(score);
        dest.writeString(genres);
        dest.writeStringList(genreList);
        dest.writeString(description);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
