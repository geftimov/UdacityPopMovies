package com.eftimoff.udacitypopmovies.app.repository.retrofit;

import com.eftimoff.udacitypopmovies.BuildConfig;

import retrofit.RequestInterceptor;

public class RetrofitRequestInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("api_key", BuildConfig.API_KEY);
    }
}
