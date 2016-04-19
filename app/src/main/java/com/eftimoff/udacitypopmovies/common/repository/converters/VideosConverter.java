package com.eftimoff.udacitypopmovies.common.repository.converters;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.VideoDao;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.VideoListDao;
import com.eftimoff.udacitypopmovies.models.Video;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by georgieftimov on 08/04/16.
 */
public class VideosConverter implements Converter<VideoListDao, List<Video>> {

    @Inject
    public VideosConverter() {

    }

    @Override
    public List<Video> convert(VideoListDao videoListDao) {
        final ArrayList<Video> videos = new ArrayList<>(videoListDao.getResults().size());
        for (final VideoDao videoDao : videoListDao.getResults()) {
            final Video video = new Video();
            video.setUrl("https://www.youtube.com/watch?v=" + videoDao.getKey());
            video.setName(videoDao.getName());
            videos.add(video);
        }
        return videos;
    }
}