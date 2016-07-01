package com.eftimoff.udacitypopmovies.app.repository.converters;

import com.eftimoff.udacitypopmovies.app.repository.retrofit.models.ReviewDao;
import com.eftimoff.udacitypopmovies.app.repository.retrofit.models.ReviewListDao;
import com.eftimoff.udacitypopmovies.app.models.Review;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ReviewsConverter implements Converter<ReviewListDao, List<Review>> {

    @Inject
    public ReviewsConverter() {

    }

    @Override
    public List<Review> convert(ReviewListDao reviewListDao) {
        final ArrayList<Review> reviews = new ArrayList<>(reviewListDao.getTotalResults());
        for (final ReviewDao reviewDao : reviewListDao.getResults()) {
            final Review review = new Review();
            review.setAuthor(reviewDao.getAuthor());
            review.setText(reviewDao.getContent());
            reviews.add(review);
        }
        return reviews;
    }
}
