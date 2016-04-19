package com.eftimoff.udacitypopmovies.features.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseActivity;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.MovieDetailsView;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.di.MovieDetailsModule;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter.MovieDetailsPresenter;
import com.eftimoff.udacitypopmovies.models.Movie;
import com.eftimoff.udacitypopmovies.models.Review;
import com.eftimoff.udacitypopmovies.models.Video;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MovieDetailsActivity extends BaseActivity implements MovieDetailsView {

    private static final String EXTRA_MOVIE = "extra_movie";
    private static final int ANIM_DURATION = 350;

    @Bind(R.id.movieImageView)
    ImageView movieImageView;
    @Bind(R.id.movieScore)
    TextView movieScore;
    @Bind(R.id.movieDescription)
    TextView movieDescription;
    @Bind(R.id.firstGenre)
    TextView firstGenre;
    @Bind(R.id.secondGenre)
    TextView secondGenre;
    @Bind(R.id.thirdGenre)
    TextView thirdGenre;

    @Inject
    MovieDetailsPresenter movieDetailsPresenter;

    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        movieDetailsPresenter.getVideos(movie.getId());
        movieDetailsPresenter.getReviews(movie.getId());
        initActionBar();
        initImage();
        initScoreText();
        initDescriptionText();
        initGenres();
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication
                .getComponent()
                .plus(new MovieDetailsModule(this))
                .inject(this);
    }

    private void initImage() {
        Glide.with(this)
                .load(movie.getImageUrl())
                .into(movieImageView);
    }

    private void initActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            final String year = movie.getReleaseDate().substring(0, movie.getReleaseDate().indexOf("-"));
            final SpannableString spannableString = new SpannableString("(" + year + ") " + movie.getTitle());
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.gold)), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            getSupportActionBar().setTitle(spannableString);
        }
    }

    private void initScoreText() {
        movieScore.setText(getString(R.string.movie_score, movie.getScore()));
        movieScore.setAlpha(0);
        movieScore.setTranslationY(100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                movieScore.animate()
                        .alpha(1)
                        .setStartDelay(ANIM_DURATION / 3)
                        .setDuration(ANIM_DURATION * 5)
                        .setInterpolator(new DecelerateInterpolator(9))
                        .translationY(0)
                        .start();
            }
        }, 200);
    }

    private void initDescriptionText() {
        movieDescription.setText(movie.getDescription());
        movieDescription.setAlpha(0);
        movieDescription.setTranslationY(100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                movieDescription.animate()
                        .alpha(1)
                        .setStartDelay(ANIM_DURATION / 3)
                        .setDuration(ANIM_DURATION * 5)
                        .setInterpolator(new DecelerateInterpolator(9))
                        .translationY(0)
                        .start();
            }
        }, 300);
    }

    private void initGenres() {
        initFirstGenre();
        initSecondGenre();
        initThirdGenre();
    }

    private void initFirstGenre() {
        if (movie.getGenreList().size() < 1) {
            firstGenre.setVisibility(View.GONE);
            return;
        }
        firstGenre.setText(movie.getGenreList().get(0));
        firstGenre.setAlpha(0);
        firstGenre.setTranslationY(100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                firstGenre.animate()
                        .alpha(1)
                        .setStartDelay(ANIM_DURATION / 3)
                        .setDuration(ANIM_DURATION * 5)
                        .setInterpolator(new DecelerateInterpolator(9))
                        .translationY(0)
                        .start();
            }
        }, 400);
    }

    private void initSecondGenre() {
        if (movie.getGenreList().size() < 2) {
            secondGenre.setVisibility(View.GONE);

            return;
        }
        secondGenre.setText(movie.getGenreList().get(1));
        secondGenre.setAlpha(0);
        secondGenre.setTranslationY(100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                secondGenre.animate()
                        .alpha(1)
                        .setStartDelay(ANIM_DURATION / 3)
                        .setDuration(ANIM_DURATION * 5)
                        .setInterpolator(new DecelerateInterpolator(9))
                        .translationY(0)
                        .start();
            }
        }, 400);
    }

    private void initThirdGenre() {
        if (movie.getGenreList().size() < 3) {
            thirdGenre.setVisibility(View.GONE);
            return;
        }
        thirdGenre.setText(movie.getGenreList().get(2));
        thirdGenre.setAlpha(0);
        thirdGenre.setTranslationY(100);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                thirdGenre.animate()
                        .alpha(1)
                        .setStartDelay(ANIM_DURATION / 3)
                        .setDuration(ANIM_DURATION * 5)
                        .setInterpolator(new DecelerateInterpolator(9))
                        .translationY(0)
                        .start();
            }
        }, 400);
    }

    public static Intent getIntent(final Context context, final Movie movie) {
        final Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private static final String TAG = "MovieDetailsFragment";

    @Override
    public void onVideoSuccess(List<Video> videos) {
        Log.d(TAG, "onVideoSuccess() called with: " + "videos = [" + videos + "]");
    }

    @Override
    public void onVideoError(String message) {
        Log.d(TAG, "onVideoError() called with: " + "message = [" + message + "]");
    }

    @Override
    public void onReviewsSuccess(List<Review> reviews) {
        Log.d(TAG, "onReviewsSuccess() called with: " + "reviews = [" + reviews + "]");
    }

    @Override
    public void onReviewsError(String message) {
        Log.d(TAG, "onReviewsError() called with: " + "message = [" + message + "]");
    }
}
