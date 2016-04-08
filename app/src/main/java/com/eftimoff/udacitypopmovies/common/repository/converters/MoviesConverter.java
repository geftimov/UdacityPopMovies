package com.eftimoff.udacitypopmovies.common.repository.converters;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.MovieDao;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.MovieListDao;
import com.eftimoff.udacitypopmovies.models.Movie;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by georgieftimov on 08/04/16.
 */
public class MoviesConverter implements Converter<MovieListDao, List<Movie>> {

    private MovieGenreHelper movieGenreHelper;

    @Inject
    public MoviesConverter(final MovieGenreHelper movieGenreHelper) {
        this.movieGenreHelper = movieGenreHelper;
    }

    @Override
    public List<Movie> convert(final MovieListDao movieListDao) {
        final List<Movie> movies = new ArrayList<>();
        final List<MovieDao> results = movieListDao.getResults();
        for (MovieDao movieDao : results) {
            final Movie movie = new Movie();
            movie.setTitle(movieDao.getTitle());
            movie.setDescription(movieDao.getOverview());
            movie.setImageUrl("http://image.tmdb.org/t/p/w185/" + movieDao.getPosterPath());
            movie.setScore(movieDao.getVoteAverage());
            movie.setReleaseDate(movieDao.getReleaseDate());
            movie.setRuntime(movieDao.getRuntime());
            movie.setGenres(movieGenreHelper.fromIds(movieDao.getGenreIds()));
            movies.add(movie);
        }
        return movies;
    }
}
