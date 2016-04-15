package com.eftimoff.udacitypopmovies.common.repository.retrofit;

import com.eftimoff.udacitypopmovies.BuildConfig;

import retrofit.RequestInterceptor;

/**
 * Created by georgieftimov on 07/04/16.
 */
public class RetrofitRequestInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("api_key", BuildConfig.API_KEY);
    }
}
