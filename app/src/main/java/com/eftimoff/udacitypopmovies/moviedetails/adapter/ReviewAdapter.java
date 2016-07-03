package com.eftimoff.udacitypopmovies.moviedetails.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eftimoff.udacitypopmovies.R;
import com.eftimoff.udacitypopmovies.app.models.Review;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.PostersViewHolder> {

    private ReviewAdapterListener reviewAdapterListener;
    private List<Review> reviews = new ArrayList<>();

    public ReviewAdapter(final ReviewAdapterListener reviewAdapterListener) {
        this.reviewAdapterListener = reviewAdapterListener;
    }

    @Override
    public PostersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        final PostersViewHolder postersViewHolder = new PostersViewHolder(view);
        setListeners(postersViewHolder);
        return postersViewHolder;
    }

    private void setListeners(final PostersViewHolder postersViewHolder) {
        postersViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = postersViewHolder.getAdapterPosition();
                final Review review = reviews.get(position);
                reviewAdapterListener.onReviewClick(review);
            }
        });
    }

    @Override
    public void onBindViewHolder(final PostersViewHolder holder, int position) {
        final Review review = reviews.get(position);
        holder.bind(review);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public static class PostersViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.reviewAuthor)
        TextView reviewAuthor;
        @BindView(R.id.reviewText)
        TextView reviewText;

        public PostersViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void bind(final Review review) {
            reviewAuthor.setText(review.getAuthor());
            reviewText.setText(review.getText());
        }
    }
}
