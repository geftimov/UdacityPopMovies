package com.eftimoff.udacitypopmovies.features.moviedetails.details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.common.BaseFragment;
import com.eftimoff.udacitypopmovies.features.moviedetails.details.presenter.MovieDetailsPresenter;
import com.eftimoff.udacitypopmovies.models.Movie;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by georgieftimov on 06/04/16.
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

    private static final String EXTRA_MOVIE = "extra_movie";

    @Bind(R.id.movieTitle)
    TextView movieTitle;
    @Bind(R.id.movieImageView)
    ImageView movieImageView;
    @Bind(R.id.movieScore)
    TextView movieScore;
    @Bind(R.id.firstGenre)
    TextView firstGenre;
    @Bind(R.id.secondGenre)
    TextView secondGenre;
    @Bind(R.id.thirdGenre)
    TextView thirdGenre;
    @Bind(R.id.movieDescription)
    TextView movieDescription;
    @Bind(R.id.movieContainer)
    RelativeLayout movieContainer;

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

    @Override
    public void injectDependencies() {

    }
}
