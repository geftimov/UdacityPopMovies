package com.eftimoff.udacitypopmovies.common.repository;

public interface RepositoryCallback<T> {

    void onSuccess(final T t);

    void onError(final Throwable throwable);

}
