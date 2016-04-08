package com.eftimoff.udacitypopmovies.common.repository;

import com.eftimoff.udacitypopmovies.common.repository.converters.MoviesConverter;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRepository;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.RetrofitRequestInterceptor;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.TheMovieDbApi;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by georgieftimov on 07/04/16.
 */
@Module
public class RepositoryModule {

    @Provides
    MoviesConverter provideMoviesConverter() {
        return new MoviesConverter();
    }

    @Provides
    RequestInterceptor provideRequestInterceptor() {
        return new RetrofitRequestInterceptor();
    }

    @Provides
    RestAdapter provideRestAdapter(final RequestInterceptor requestInterceptor) {
        return new RestAdapter.Builder()
                .setEndpoint("https://api.themoviedb.org")
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    @Provides
    TheMovieDbApi provideTheMovieDbApi(final RestAdapter restAdapter) {
        return restAdapter.create(TheMovieDbApi.class);
    }

    @Provides
    Repository provideRepository(final TheMovieDbApi theMovieDbApi, final MoviesConverter moviesConverter) {
        return new RetrofitRepository(theMovieDbApi, moviesConverter);
    }
}
