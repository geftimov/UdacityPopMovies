package com.eftimoff.udacitypopmovies.app.repository.converters;

public interface Converter<T, R> {

    R convert(T t);
}
