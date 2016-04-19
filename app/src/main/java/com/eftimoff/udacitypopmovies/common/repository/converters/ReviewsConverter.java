package com.eftimoff.udacitypopmovies.common.repository.converters;

import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.ReviewDao;
import com.eftimoff.udacitypopmovies.common.repository.retrofit.models.ReviewListDao;
import com.eftimoff.udacitypopmovies.models.Review;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by georgieftimov on 08/04/16.
 */
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
