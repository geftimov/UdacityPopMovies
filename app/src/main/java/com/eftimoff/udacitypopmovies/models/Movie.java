package com.eftimoff.udacitypopmovies.models;

/**
 * Created by georgieftimov on 07/04/16.
 */
public class Movie {

    private String title;
    private String imageUrl;
    private String releaseDate;
    private int runtime;
    private float score;
    private String genres;
    private String description;

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
}
