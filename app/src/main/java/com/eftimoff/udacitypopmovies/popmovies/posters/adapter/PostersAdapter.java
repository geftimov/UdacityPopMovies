package com.eftimoff.udacitypopmovies.popmovies.posters.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.models.Movie;
import com.github.florent37.glidepalette.GlidePalette;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostersAdapter extends SelectableRecyclerViewAdapter<PostersAdapter.PostersViewHolder> {

    private PosterAdapterListener posterAdapterListener;
    private List<Movie> movies = new ArrayList<>();
    private boolean isMasterDetailFlow;

    public PostersAdapter(PosterAdapterListener posterAdapterListener) {
        this.posterAdapterListener = posterAdapterListener;
    }

    @Override
    public PostersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster, parent, false);
        final PostersViewHolder postersViewHolder = new PostersViewHolder(view);
        setListeners(postersViewHolder);
        isMasterDetailFlow = parent.getResources().getBoolean(R.bool.is_master_detail_flow);
        return postersViewHolder;
    }

    private void setListeners(final PostersViewHolder postersViewHolder) {
        postersViewHolder.movieContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = postersViewHolder.getAdapterPosition();
                final Movie movie = movies.get(position);
                if (posterAdapterListener != null) {
                    posterAdapterListener.onMovieClicked(postersViewHolder.posterImageView, movie);
                }
                if (isMasterDetailFlow) {
                    clearSelections();
                    setSelected(position);
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(final PostersViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        final Movie movie = movies.get(position);
        Glide.with(holder.posterImageView.getContext())
                .load(movie.getImageUrl())
                .listener(GlidePalette.with(movie.getImageUrl())
                        .use(GlidePalette.Profile.MUTED_DARK)
                        .intoBackground(holder.movieInformationContainer))
                .into(holder.posterImageView);
        holder.movieTitle.setText(movie.getTitle());
        holder.movieGenres.setText(movie.getGenres());
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public List<Movie> getItems() {
        return movies;
    }

    public static class PostersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieContainer)
        View movieContainer;
        @BindView(R.id.posterImageView)
        ImageView posterImageView;
        @BindView(R.id.movieInformationContainer)
        View movieInformationContainer;
        @BindView(R.id.movieTitle)
        TextView movieTitle;
        @BindView(R.id.movieGenres)
        TextView movieGenres;

        public PostersViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
