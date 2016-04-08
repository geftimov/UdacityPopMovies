package com.eftimoff.udacitypopmovies.features.popmovies.posters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.models.Movie;
import com.github.florent37.glidepalette.BitmapPalette;
import com.github.florent37.glidepalette.GlidePalette;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by georgieftimov on 08/04/16.
 */
public class PostersAdapter extends RecyclerView.Adapter<PostersAdapter.PostersViewHolder> {

    private List<Movie> movies = new ArrayList<>();

    @Override
    public PostersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster, parent, false);
        return new PostersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PostersViewHolder holder, int position) {
        final Movie movie = movies.get(position);
        Glide.with(holder.posterImageView.getContext())
                .load(movie.getImageUrl())
                .listener(GlidePalette.with(movie.getImageUrl())
                        .use(GlidePalette.Profile.MUTED_DARK)
                        .intoBackground(holder.movieInformationContainer)
                        .intoTextColor(holder.movieTitle)
                        .intoTextColor(holder.movieGenres))
                .into(holder.posterImageView);
        holder.movieTitle.setText(movie.getTitle());
        holder.movieGenres.setText(movie.getGenres());

//        holder.movieScore.setText(String.format(Locale.getDefault(), "%.2f", movie.getScore()));
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class PostersViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.posterImageView)
        ImageView posterImageView;
        @Bind(R.id.movieInformationContainer)
        View movieInformationContainer;
        @Bind(R.id.movieTitle)
        TextView movieTitle;
        @Bind(R.id.movieGenres)
        TextView movieGenres;

        public PostersViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
