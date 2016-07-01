package com.eftimoff.udacitypopmovies.common.repository.retrofit.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoListDao {

    @SerializedName("id")
    private int id;
    @SerializedName("results")
    private List<VideoDao> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<VideoDao> getResults() {
        return results;
    }

    public void setResults(List<VideoDao> results) {
        this.results = results;
    }
}
