package com.eftimoff.udacitypopmovies.app.repository;

import android.content.Context;

import com.eftimoff.udacitypopmovies.BuildConfig;
import com.eftimoff.udacitypopmovies.app.repository.converters.MovieGenreHelper;
import com.eftimoff.udacitypopmovies.app.repository.converters.MoviesConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.ReviewsConverter;
import com.eftimoff.udacitypopmovies.app.repository.converters.VideosConverter;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.RetrofitRequestInterceptor;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.TheMovieDbApi;
import com.eftimoff.udacitypopmovies.app.repository.storage.LocalStorage;
import com.eftimoff.udacitypopmovies.app.repository.storage.LocalStorageImpl;

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
    Repository provideRepository(final TheMovieDbApi theMovieDbApi, final MoviesConverter moviesConverter, final VideosConverter videosConverter, final ReviewsConverter reviewsConverter, final LocalStorage localStorage) {
        return new RepositoryImpl(theMovieDbApi, moviesConverter, videosConverter, reviewsConverter, localStorage);
    }

    @Provides
    LocalStorage provideLocalStorage(Context context) {
        return new LocalStorageImpl(context);
    }
}
