package com.eftimoff.udacitypopmovies.common.repository.converters;

public interface Converter<T, R> {

    R convert(T t);
}
