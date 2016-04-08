package com.eftimoff.udacitypopmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by georgieftimov on 07/04/16.
 */
public class Movie implements Parcelable {

    private String title;
    private String imageUrl;
    private String releaseDate;
    private int runtime;
    private float score;
    private String genres;
    private String description;

    public Movie() {
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int time) {
        this.runtime = time;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", runtime=" + runtime +
                ", score=" + score +
                ", description='" + description + '\'' +
                '}';
    }


    protected Movie(Parcel in) {
        title = in.readString();
        imageUrl = in.readString();
        releaseDate = in.readString();
        runtime = in.readInt();
        score = in.readFloat();
        genres = in.readString();
        description = in.readString();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(releaseDate);
        dest.writeInt(runtime);
        dest.writeFloat(score);
        dest.writeString(genres);
        dest.writeString(description);
    }
}
