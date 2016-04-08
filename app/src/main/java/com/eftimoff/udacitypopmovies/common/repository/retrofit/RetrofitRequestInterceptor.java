package com.eftimoff.udacitypopmovies.common.repository.retrofit;

import retrofit.RequestInterceptor;

/**
 * Created by georgieftimov on 07/04/16.
 */
public class RetrofitRequestInterceptor implements RequestInterceptor {

    @Override
    public void intercept(RequestFacade request) {
        request.addQueryParam("api_key", "976e918ccc65d572020713b1f9b050c4");
    }
}
