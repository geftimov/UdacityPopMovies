package com.eftimoff.udacitypopmovies.moviedetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.PopMoviesApplication;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.BaseFragment;
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

public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView, VideoAdapterListener, ReviewAdapterListener {

    private static final String EXTRA_MOVIE = "extra_movie";

    @BindView(R.id.movieTitle)
    TextView movieTitle;
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
    VideoAdapter videoAdapter;
    @Inject
    ReviewAdapter reviewAdapter;
    @Inject
    VideoHelper videoHelper;
    @Inject
    MovieDetailsPresenter movieDetailsPresenter;

    private Movie movie;

    public static MovieDetailsFragment newInstance(final Movie movie) {
        final MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        final Bundle bundle = new Bundle();
        bundle.putParcelable(EXTRA_MOVIE, movie);
        movieDetailsFragment.setArguments(bundle);
        return movieDetailsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movie = getArguments().getParcelable(EXTRA_MOVIE);

        PopMoviesApplication
                .getComponent()
                .plus(new MovieDetailsModule(this, this, this))
                .inject(this);

        movieDetailsPresenter.getVideos(movie.getId());
        movieDetailsPresenter.getReviews(movie.getId());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_movie_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String year = movie.getReleaseDate().substring(0, movie.getReleaseDate().indexOf("-"));
        final SpannableString spannableString = new SpannableString("(" + year + ") " + movie.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getActivity(), R.color.gold)), 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        movieTitle.setText(spannableString);
        Glide.with(this)
                .load(movie.getImageUrl())
                .into(movieImageView);
        movieScore.setText(getString(R.string.movie_score, movie.getScore()));
        movieDescription.setText(movie.getDescription());
        initGenres();
        initLists();
        movieFavourite.setChecked(movieDetailsPresenter.isFavourite(movie.getId()));
    }

    @OnClick(R.id.movieFavourite)
    public void onMovieFavourite() {
        if (movieFavourite.isChecked()) {
            movieDetailsPresenter.saveFavourite(movie, reviewAdapter.getReviews(), videoAdapter.getVideos());
        } else {
            movieDetailsPresenter.removeFavourite(movie);
        }
    }

    private void initGenres() {
        if (movie.getGenreList().size() < 1) {
            firstGenre.setVisibility(View.GONE);
            return;
        }
        firstGenre.setText(movie.getGenreList().get(0));
        if (movie.getGenreList().size() < 2) {
            secondGenre.setVisibility(View.GONE);

            return;
        }
        secondGenre.setText(movie.getGenreList().get(1));
        if (movie.getGenreList().size() < 3) {
            thirdGenre.setVisibility(View.GONE);
            return;
        }
        thirdGenre.setText(movie.getGenreList().get(2));
    }

    private void initLists() {
        movieVideos.setNestedScrollingEnabled(false);
        movieVideos.setHasFixedSize(true);
        movieVideos.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        movieVideos.setAdapter(videoAdapter);
        movieReviews.setNestedScrollingEnabled(false);
        movieReviews.setHasFixedSize(true);
        movieReviews.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        movieReviews.setAdapter(reviewAdapter);
    }

    @Override
    public void injectDependencies() {
        PopMoviesApplication
                .getComponent()
                .plus(new MovieDetailsModule(this, this, this))
                .inject(this);
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
