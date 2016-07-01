package com.eftimoff.udacitypopmovies.app.repository;

import com.eftimoff.udacitypopmovies.BuildConfig;
import com.eftimoff.udacitypopmovies.app.repository.converters.MovieGenreHelper;
import com.eftimoff.udacitypopmovies.app.repository.converters.MoviesConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.ReviewsConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.VideosConverter;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRequestInterceptor;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.TheMovieDbApi;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

@Module
public class RepositoryModule {

    @Provides
    MovieGenreHelper provideMovieGenreHelper() {
        return new MovieGenreHelper();
    }

    @Provides
    MoviesConverter provideMoviesConverter(final MovieGenreHelper movieGenreHelper) {
        return new MoviesConverter(movieGenreHelper);
    }

    @Provides
    VideosConverter provideVideosConverter() {
        return new VideosConverter();
    }

    @Provides
    ReviewsConverter provideReviewsConverter() {
        return new ReviewsConverter();
    }

    @Provides
    RequestInterceptor provideRequestInterceptor() {
        return new RetrofitRequestInterceptor();
    }

    @Provides
    RestAdapter provideRestAdapter(final RequestInterceptor requestInterceptor) {
        return new RestAdapter.Builder()
                .setEndpoint(BuildConfig.ENDPOINT)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    @Provides
    TheMovieDbApi provideTheMovieDbApi(final RestAdapter restAdapter) {
        return restAdapter.create(TheMovieDbApi.class);
    }

    @Provides
    Repository provideRepository(final TheMovieDbApi theMovieDbApi, final MoviesConverter moviesConverter, final VideosConverter videosConverter, final ReviewsConverter reviewsConverter) {
        return new RetrofitRepository(theMovieDbApi, moviesConverter, videosConverter, reviewsConverter);
    }
}
