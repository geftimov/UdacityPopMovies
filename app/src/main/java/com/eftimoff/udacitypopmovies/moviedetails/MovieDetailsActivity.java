package com.eftimoff.udacitypopmovies.moviedetails;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.BaseActivity;
import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.eftimoff.udacitypopmovies.app.models.Review;
import com.eftimoff.udacitypopmovies.app.models.Video;
import com.eftimoff.udacitypopmovies.app.utils.VideoHelper;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.ReviewAdapter;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.ReviewAdapterListener;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.VideoAdapter;
import com.eftimoff.udacitypopmovies.moviedetails.adapter.VideoAdapterListener;
import com.eftimoff.udacitypopmovies.moviedetails.di.MovieDetailsModule;
import com.eftimoff.udacitypopmovies.moviedetails.presenter.MovieDetailsPresenter;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MovieDetailsActivity extends BaseActivity implements MovieDetailsView, VideoAdapterListener, ReviewAdapterListener {

    private static final String EXTRA_MOVIE = "extra_movie";
    private static final int ANIM_DURATION = 350;

    @BindView(R.id.movieImageView)
    ImageView movieImageView;
    @BindView(R.id.movieScore)
    TextView movieScore;
    @BindView(R.id.movieDescription)
    TextView movieDescription;
    @BindView(R.id.firstGenre)
    TextView firstGenre;
    @BindView(R.id.secondGenre)
    TextView secondGenre;
    @BindView(R.id.thirdGenre)
    TextView thirdGenre;
    @BindView(R.id.movieVideos)
    RecyclerView movieVideos;
    @BindView(R.id.movieVideoTitle)
    TextView movieVideoTitle;
    @BindView(R.id.movieReviewsTitle)
    TextView movieReviewsTitle;
    @BindView(R.id.movieReviews)
    RecyclerView movieReviews;
    @BindView(R.id.movieFavourite)
    ShineButton movieFavourite;

    @Inject
    MovieDetailsPresenter movieDetailsPresenter;
    @Inject
    VideoAdapter videoAdapter;
    @Inject
    ReviewAdapter reviewAdapter;
    @Inject
    VideoHelper videoHelper;

    private Movie movie;

    public static Intent getIntent(final Context context, final Movie movie) {
        final Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        ButterKnife.bind(this);
        movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        initActionBar();
        initImage();
        initScoreText();
        initDescriptionText();
        initGenres();
        initLists();
        movieDetailsPresenter.getVideos(movie.getId());
        movieDetailsPresenter.getReviews(movie.getId());
        movieFavourite.setChecked(movieDetailsPresenter.isFavourite(movie.getId()));
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication
                .getComponent()
                .plus(new MovieDetailsModule(this, this, this))
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


    private void initLists() {
        movieVideos.setNestedScrollingEnabled(false);
        movieVideos.setHasFixedSize(true);
        movieVideos.setLayoutManager(new LinearLayoutManager(this));
        movieVideos.setAdapter(videoAdapter);
        movieReviews.setNestedScrollingEnabled(false);
        movieReviews.setHasFixedSize(true);
        movieReviews.setLayoutManager(new LinearLayoutManager(this));
        movieReviews.setAdapter(reviewAdapter);
    }

    @OnClick(R.id.movieFavourite)
    public void onMovieFavourite() {
        if (movieFavourite.isChecked()) {
            movieDetailsPresenter.saveFavourite(movie, reviewAdapter.getReviews(), videoAdapter.getVideos());
        } else {
            movieDetailsPresenter.removeFavourite(movie);
        }
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

    @Override
    public void onVideoSuccess(List<Video> videos) {
        if (!videos.isEmpty()) {
            movieVideoTitle.setVisibility(View.VISIBLE);
            movieVideos.setVisibility(View.VISIBLE);
            videoAdapter.setVideos(videos);
        }
    }

    @Override
    public void onVideoError(String message) {
        movieVideoTitle.setVisibility(View.GONE);
        movieVideos.setVisibility(View.GONE);
    }

    @Override
    public void onReviewsSuccess(List<Review> reviews) {
        if (!reviews.isEmpty()) {
            movieReviewsTitle.setVisibility(View.VISIBLE);
            movieReviews.setVisibility(View.VISIBLE);
            reviewAdapter.setReviews(reviews);
        }
    }

    @Override
    public void onReviewsError(String message) {
        movieReviewsTitle.setVisibility(View.GONE);
        movieReviews.setVisibility(View.GONE);
    }

    @Override
    public void onVideoClick(Video video) {
        videoHelper.watchYoutubeVideo(video.getKey());
    }

    @Override
    public void onReviewClick(Review review) {

    }
}
