package com.eftimoff.udacitypopmovies.app.repository.storage;

import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;

import java.util.List;

public class MovieWrapper {

    private int id;
    private Movie movie;
    private List<Review> reviews;
    private List<Video> videos;

    public MovieWrapper(int id, Movie movie, List<Review> reviews, List<Video> videos) {
        this.id = id;
        this.movie = movie;
        this.reviews = reviews;
        this.videos = videos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
