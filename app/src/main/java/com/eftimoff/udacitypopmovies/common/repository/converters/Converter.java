package com.eftimoff.udacitypopmovies.common.repository.converters;

/**
 * Created by georgieftimov on 08/04/16.
 */
public interface Converter<T, R> {

    R convert(T t);
}
