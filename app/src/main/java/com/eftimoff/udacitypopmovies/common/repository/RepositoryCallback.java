package com.eftimoff.udacitypopmovies.common.repository;

/**
 * Created by georgieftimov on 08/04/16.
 */
public interface RepositoryCallback<T> {

    void onSuccess(final T t);

    void onError(final Throwable throwable);

}
